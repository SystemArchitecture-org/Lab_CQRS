package readside.rest;

import eventside.domain.CreateBookingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import readside.projection.api.EventProcessorService;
import readside.domain.AvailableRoom;
import readside.domain.BookedStay;
import readside.domain.repositories.AvailableRoomsRepository;
import readside.domain.repositories.BookingRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class ReadRestController {

    @Autowired
    private EventProcessorService eventProcessorService;

    @Autowired
    private AvailableRoomsRepository availableRoomsRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping(value = "/createBookingEvent", consumes = "application/json", produces = "application/json")
    public boolean addCreateBookingEvent(@RequestBody CreateBookingEvent event) {
        // TODO: process event in repository
        //availableRooms.processEvent(event);
        System.out.println("Event received: " + event);
        return true;
    }

}
