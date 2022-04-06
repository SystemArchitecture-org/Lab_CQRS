package writeside.domain.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import writeside.domain.Booking;

@Component
public interface BookingRepository {
    void addBooking(Booking booking);
    void removeBooking(Booking booking);

}
