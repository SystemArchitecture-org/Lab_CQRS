package eventside.domain;

import java.io.Serializable;

public class CreateBookingEvent extends Event{
    private String bookingID;
    private String roomNumber;

    public CreateBookingEvent(String booking) {
        super();
        this.booking = booking;
    }
}
