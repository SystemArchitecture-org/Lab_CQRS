package writeside.application;

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

//    public BookingServiceImpl(BookingRepository bookingRepository, EventPublisher eventPublisher) {
//        this.bookingRepository = bookingRepository;
//        this.eventPublisher = eventPublisher;
//    }

    public void createBooking(Booking booking){
        bookingRepository.addBooking(booking);
        eventPublisher.publishCreateBookingEvent(new CreateBookingEvent(booking));
    }

    public void cancelBooking(Booking booking){
        bookingRepository.removeBooking(booking);
    }
}
