package eventside.rest;

import eventside.infrastructure.EventRepository;
import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventRestController {

    @Autowired
    private EventRepository repository;

    @PostMapping(value = "/createBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCreateBookingEvent(@RequestBody CreateBookingEvent event) {
        System.out.println("Event received: " + event);
        repository.processEvent(event);
        return true;
    }

    @PostMapping(value = "/cancelBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCancelBookingEvent(@RequestBody CancelBookingEvent event) {
        System.out.println("Event received: " + event);
        repository.processEvent(event);
        return true;
    }

    @PostMapping
    public boolean subscribe(@RequestParam String host) {
        repository.attach(host);
        return true;
    }
}
