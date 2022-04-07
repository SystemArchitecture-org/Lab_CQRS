package at.fhv.lab1reference;

import eventside.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import writeside.domain.repositories.BookingRepository;
import writeside.EventPublisher;
import writeside.application.BookingServiceImpl;
import writeside.application.api.BookingService;
import writeside.domain.Booking;
import writeside.domain.Customer;
import writeside.domain.Room;
import writeside.domain.repositories.RoomRepository;
import writeside.domain.valueobjects.Address;
import writeside.infrastructure.BookingRepositoryImpl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@Configuration
@ComponentScan("writeside")
public class WriteSide {

    @Autowired
    private EventPublisher publisher;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    public static void main(String[] args) {
        SpringApplication.run(WriteSide.class, args);


    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Optional<Room> roomOpt = roomRepository.getRoomByRoomNumber(101);

            if(roomOpt.isPresent()){
                List<Room> rooms = new LinkedList<>();
                Room room = roomOpt.get();
                rooms.add(room);


                Address address = new Address("Oberradin", "6751", "Austria", "Bludenz");
                Customer customer = new Customer(UUID.randomUUID(), "Marco", address);
                Booking booking = new Booking(UUID.randomUUID(), rooms, customer, LocalDate.now(), LocalDate.now().plusDays(4));

                bookingService.createBooking(booking);


            }


        };
    }
}
