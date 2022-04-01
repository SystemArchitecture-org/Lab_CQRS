package writeside.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import writeside.domain.Booking;
import writeside.domain.repositories.BookingRepository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepository {
    private List<Booking> bookingDataBase = new LinkedList<>();

    public void addBooking(Booking booking){
        bookingDataBase.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookingDataBase.remove(booking);
    }
}
