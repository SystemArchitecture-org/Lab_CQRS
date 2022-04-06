package readside.infrastructure;

import org.springframework.stereotype.Component;
import readside.domain.BookedStay;
import readside.domain.repositories.BookingRepository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BookingRepositoryImpl implements BookingRepository {
    private List<BookedStay> bookingDatabase = new LinkedList<>();


    public void addBooking(BookedStay booking){
        bookingDatabase.add(booking);
    }

    public void cancelBooking(BookedStay booking){
        bookingDatabase.remove(booking);
    }

    public List<BookedStay> getBookings(LocalDate from, LocalDate to){
        List<BookedStay> bookings = new LinkedList<>();

        for (BookedStay booking:bookingDatabase) {
            if(!booking.getFromDate().isBefore(from) && !booking.getToDate().isAfter(to)){
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public Optional<BookedStay> getBookingById(UUID bookingId){
        return bookingDatabase.stream().filter(b -> b.getBookingID().equals(bookingId)).findFirst();

    }
}

