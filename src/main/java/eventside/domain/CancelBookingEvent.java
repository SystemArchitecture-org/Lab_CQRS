package eventside.domain;

public class CancelBookingEvent extends Event{
    private final String bookingID;

    public CancelBookingEvent(String bookingID) {
        super();
        this.bookingID = bookingID;
    }

    @Override
    public String uri() {
        return "/cancelBookingEvent";
    }

    public String getBookingID() {
        return bookingID;
    }

}
