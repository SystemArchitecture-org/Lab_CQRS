package eventside.rest;

import eventside.infrastructure.EventRepository;
import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @PostMapping(value = "/createBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCreateBookingEvent(@RequestBody CreateBookingEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

    @PostMapping(value = "/cancelBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCancelBookingEvent(@RequestBody CancelBookingEvent event) {
        // TODO: process event in repository
        repository.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }
}
