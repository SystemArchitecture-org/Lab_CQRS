package writeside.application;

import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import writeside.EventPublisher;
import writeside.application.api.BookingService;
import writeside.domain.Booking;
import writeside.domain.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EventPublisher eventPublisher;

    public void createBooking(Booking booking){
        bookingRepository.addBooking(booking);

        if (eventPublisher.publishCreateBookingEvent(new CreateBookingEvent(booking))) {
            System.out.println("Create booking event successfully published");
        }
    }

    public void cancelBooking(Booking booking){
        bookingRepository.removeBooking(booking);

        if (eventPublisher.publishCancelBookingEvent(new CancelBookingEvent(booking.getBookingID().toString()))) {
            System.out.println("Cancel booking event successfully published");
        }
    }
}
