package readside.projection.api;

import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;

public interface EventProcessorService {

    void processCreateBookingEvent(CreateBookingEvent createBookingEvent);

    void processCancelBookingEvent(CancelBookingEvent cancelBookingEvent);

}
