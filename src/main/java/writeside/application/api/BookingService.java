package writeside.application.api;

import writeside.domain.Booking;

public interface BookingService {

    void createBooking(Booking booking);

    void cancelBooking(Booking booking);

}
