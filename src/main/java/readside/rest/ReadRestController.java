package readside.rest;

import eventside.domain.CreateBookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import readside.domain.repository.AvailableRooms;

@RestController
public class ReadRestController {

    @Autowired
    private AvailableRooms availableRooms;

    @PostMapping(value = "/createBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCreateBookingEvent(@RequestBody CreateBookingEvent event) {
        // TODO: process event in repository
        //availableRooms.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

}
