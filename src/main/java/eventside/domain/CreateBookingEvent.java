package eventside.domain;

import writeside.domain.Booking;
import writeside.domain.Room;

import java.util.ArrayList;
import java.util.List;

public class CreateBookingEvent extends Event {

    private String bookingID;
    private final List<String> rooms = new ArrayList<>();

    private String customerName;
    private String customerAddressStreet;
    private String customerAddressZip;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String customerID;

    private String fromDate;
    private String toDate;

    public CreateBookingEvent() {
    }

    public CreateBookingEvent(Booking booking) {
        super();
        this.bookingID = booking.getBookingID().toString();
        this.customerID = booking.getCustomer().getCustomerID().toString();
        this.customerAddressStreet = booking.getCustomer().getAddress().getStreet();
        this.customerAddressZip = booking.getCustomer().getAddress().getZip();
        this.customerAddressCountry = booking.getCustomer().getAddress().getCountry();
        this.customerAddressCity = booking.getCustomer().getAddress().getCity();
        this.customerName = booking.getCustomer().getName();
        List<Room> bookingRooms = booking.getRooms();
        for (Room room : bookingRooms) {
            rooms.add(room.getRoomNumber().toString());
        }
        this.fromDate = booking.getFromDate().toString();
        this.toDate = booking.getToDate().toString();
    }

    @Override
    public String uri() {
        return "/createBookingEvent";
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

    public String getCustomerAddressStreet() {
        return customerAddressStreet;
    }

    public String getCustomerAddressZip() {
        return customerAddressZip;
    }

    public String getCustomerAddressCountry() {
        return customerAddressCountry;
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
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
