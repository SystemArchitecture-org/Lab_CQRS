package readside.domain.repositories;

import readside.domain.BookedStay;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository {

    void addBooking(BookedStay booking);

    void cancelBooking(BookedStay booking);

    Optional<BookedStay> getBookingById(UUID bookingId);

    List<BookedStay> getBookings(LocalDate from, LocalDate to);

}
