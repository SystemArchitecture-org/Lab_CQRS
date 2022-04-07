package readside.projection;

import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import readside.domain.AvailableRoom;
import readside.domain.BookedStay;
import readside.domain.repositories.AvailableRoomsRepository;
import readside.domain.repositories.BookingRepository;

import readside.projection.api.EventProcessorService;
import writeside.domain.Customer;
import writeside.domain.Room;
import writeside.domain.valueobjects.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class EventProcessorServiceImpl implements EventProcessorService {

    @Autowired
    AvailableRoomsRepository availableRoomsRepository;

    @Autowired
    BookingRepository bookingRepository;

    public void processCreateBookingEvent(CreateBookingEvent createBookingEvent) {
        List<AvailableRoom> availableRooms = availableRoomsRepository.getAvailableRooms();

        LocalDate cbeFromDate = LocalDate.parse(createBookingEvent.getFromDate());
        LocalDate cbeToDate = LocalDate.parse(createBookingEvent.getToDate());

        List<String> roomNumbers = createBookingEvent.getRooms();

        List<Room> roomsToBook = new ArrayList<>();

        for (String roomNumber : roomNumbers) {
            for (AvailableRoom availableRoom : availableRooms) {

                LocalDate arFromDate = availableRoom.getAvailableFrom();
                LocalDate arToDate = availableRoom.getAvailableTo();

                if (Integer.parseInt(roomNumber) == availableRoom.getRoomNumber()) {

                    if (cbeFromDate.isAfter(arFromDate) || cbeFromDate.isEqual(arFromDate) &&
                            (cbeToDate.isBefore(arToDate) || cbeToDate.isEqual(arToDate))) {

                        if (!cbeFromDate.isEqual(arFromDate)) {
                            availableRoomsRepository.add(new AvailableRoom(
                                    Integer.parseInt(roomNumber),
                                    availableRoom.getNumberOfBeds(),
                                    arFromDate,
                                    cbeFromDate
                            ));
                        }

                        if (!cbeToDate.isEqual(arToDate)) {
                            availableRoomsRepository.add(new AvailableRoom(
                                    Integer.parseInt(roomNumber),
                                    availableRoom.getNumberOfBeds(),
                                    cbeToDate,
                                    arToDate
                            ));
                        }

                        roomsToBook.add(new Room(
                                availableRoom.getRoomNumber(),
                                availableRoom.getNumberOfBeds()
                        ));

                        availableRoomsRepository.remove(availableRoom);
                        break;
                    }
                }
            }
        }

        BookedStay bookedStay = new BookedStay(
                UUID.fromString(createBookingEvent.getBookingID()),
                roomsToBook,
                new Customer(
                        UUID.fromString(createBookingEvent.getCustomerID()),
                        createBookingEvent.getCustomerName(),
                        new Address(
                                createBookingEvent.getCustomerAddressStreet(),
                                createBookingEvent.getCustomerAddressZip(),
                                createBookingEvent.getCustomerAddressCountry(),
                                createBookingEvent.getCustomerAddressCity()
                        )
                ),
                LocalDate.parse(createBookingEvent.getFromDate()),
                LocalDate.parse(createBookingEvent.getToDate())
        );

        bookingRepository.addBooking(bookedStay);
    }


    public void processCancelBookingEvent(CancelBookingEvent cancelBookingEvent) {

        Optional<BookedStay> bookingOpt = bookingRepository.getBookingById(UUID.fromString(cancelBookingEvent.getBookingID()));

        if (bookingOpt.isPresent()) {
            BookedStay booking = bookingOpt.get();
            bookingRepository.cancelBooking(booking);
            LocalDate bookingFromDate = booking.getFromDate();
            LocalDate bookingToDate = booking.getToDate();

            for (Room room : booking.getRooms()) {
                Optional<AvailableRoom> availableRoomBeforeOpt = availableRoomsRepository.getAvailableRoomBefore(bookingFromDate, room.getRoomNumber());
                Optional<AvailableRoom> availableRoomAfterOpt = availableRoomsRepository.getAvailableRoomAfter(bookingToDate, room.getRoomNumber());

                if (availableRoomBeforeOpt.isPresent() && availableRoomAfterOpt.isPresent()) {
                    AvailableRoom roomBefore = availableRoomBeforeOpt.get();
                    AvailableRoom roomAfter = availableRoomAfterOpt.get();

                    availableRoomsRepository.add(new AvailableRoom(room.getRoomNumber(), room.getNumberOfBeds(), roomBefore.getAvailableFrom(), roomAfter.getAvailableTo()));
                    availableRoomsRepository.remove(roomBefore);
                    availableRoomsRepository.remove(roomAfter);

                } else if (availableRoomBeforeOpt.isPresent()) {
                    AvailableRoom roomBefore = availableRoomBeforeOpt.get();
                    availableRoomsRepository.add(new AvailableRoom(room.getRoomNumber(), room.getNumberOfBeds(), roomBefore.getAvailableFrom(), booking.getToDate()));
                    availableRoomsRepository.remove(roomBefore);

                } else if (availableRoomAfterOpt.isPresent()) {
                    AvailableRoom roomAfter = availableRoomAfterOpt.get();
                    availableRoomsRepository.add(new AvailableRoom(room.getRoomNumber(), room.getNumberOfBeds(), booking.getFromDate(), roomAfter.getAvailableTo()));
                    availableRoomsRepository.remove(roomAfter);

                } else {
                    availableRoomsRepository.add(new AvailableRoom(room.getRoomNumber(), room.getNumberOfBeds(), booking.getFromDate(), booking.getToDate()));
                }
            }
        }
    }

}
