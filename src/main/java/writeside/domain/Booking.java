package writeside.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Booking implements Serializable {
    private UUID bookingID;
    private List<Room> rooms;
    private Customer customer;

    public Booking(UUID bookingID, List<Room> rooms, Customer customer) {
        this.bookingID = bookingID;
        this.rooms = rooms;
        this.customer = customer;
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
}
