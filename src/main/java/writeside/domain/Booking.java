package writeside.domain;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Booking implements Serializable {

    private final UUID bookingID;
    private final List<Room> rooms;
    private final Customer customer;
    private final LocalDate fromDate;
    private final LocalDate toDate;

    public Booking(UUID bookingID, List<Room> rooms, Customer customer, LocalDate fromDate, LocalDate toDate) {
        this.bookingID = bookingID;
        this.rooms = rooms;
        this.customer = customer;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }
}
