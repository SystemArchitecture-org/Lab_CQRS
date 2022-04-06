package eventside.domain;

public class CancelBookingEvent extends Event{
    private String booking;

    public CancelBookingEvent(String booking) {
        super();
        this.booking = booking;
    }

    @Override
    public String uri() {
        return "/cancelBooking";
    }

    public String getBookingID() {
        return bookingID;
    }

}
