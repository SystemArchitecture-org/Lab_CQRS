package eventside.domain;

import writeside.domain.Booking;
import writeside.domain.Customer;
import writeside.domain.Room;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CreateBookingEvent extends Event{

    private String bookingID;
    private List<String> rooms = new LinkedList<>();

    private String customerName;
    private String customerAddress;
    private String customerID;

    private String fromDate;
    private String toDate;

    public CreateBookingEvent() {
    }

    public CreateBookingEvent(Booking booking) {
        super();
        this.bookingID = booking.getBookingID().toString();
        this.customerID = booking.getCustomer().getCustomerID().toString();
        this.customerAddress = booking.getCustomer().getAddress().toString();
        this.customerName = booking.getCustomer().getName();
        List<Room> bookingRooms = booking.getRooms();
        for (Room room:bookingRooms) {
            rooms.add(Integer.toString(room.getRoomNumber()));
        }
        this.fromDate = booking.getFromDate().toString();
        this.toDate = booking.getToDate().toString();
    }

    public String getBookingID() {
        return bookingID;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
