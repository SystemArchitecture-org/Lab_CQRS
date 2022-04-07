package readside.rest;

import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;

import readside.projection.api.EventProcessorService;
import readside.domain.AvailableRoom;
import readside.domain.BookedStay;
import readside.domain.repositories.AvailableRoomsRepository;
import readside.domain.repositories.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ReadRestController {

    @Autowired
    private EventProcessorService eventProcessorService;

    @Autowired
    private AvailableRoomsRepository availableRoomsRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping(value = "/createBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean createBookingEvent(@RequestBody CreateBookingEvent event) {

        eventProcessorService.processCreateBookingEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/cancelBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean cancelBookingEvent(@RequestBody CancelBookingEvent event){

        eventProcessorService.processCancelBookingEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @GetMapping(value = "/freeRooms")
    public List<AvailableRoom> getFreeRooms(@RequestParam String from, @RequestParam String to, @RequestParam int personCount) {
        LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_DATE);
        LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ISO_DATE);

        return availableRoomsRepository.getFreeRooms(fromDate, toDate, personCount);
    }

    @GetMapping(value = "/bookings")
    public List<BookedStay> getFreeRooms(@RequestParam String from, @RequestParam String to) {
        LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_DATE);
        LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ISO_DATE);

        return bookingRepository.getBookings(fromDate, toDate);
    }

}
