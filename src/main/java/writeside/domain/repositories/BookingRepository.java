package writeside.domain.repositories;

import writeside.domain.Booking;

public interface BookingRepository {
    void addBooking(Booking booking);
    void removeBooking(Booking booking);
}
