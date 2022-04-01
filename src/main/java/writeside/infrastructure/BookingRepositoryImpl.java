package writeside.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import writeside.domain.Booking;
import writeside.domain.repositories.BookingRepository;

import java.util.LinkedList;
import java.util.List;

@Component
public class BookingRepositoryImpl implements BookingRepository {
    private List<Booking> bookingDataBase = new LinkedList<>();

    @Override
    public void addBooking(Booking booking){
        bookingDataBase.add(booking);
    }

    @Override
    public void removeBooking(Booking booking) {
        bookingDataBase.remove(booking);
    }
}
