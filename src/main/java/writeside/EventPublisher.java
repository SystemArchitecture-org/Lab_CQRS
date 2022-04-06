package writeside;

import eventside.domain.CancelBookingEvent;
import eventside.domain.CreateBookingEvent;
import eventside.domain.Event;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class EventPublisher {

    private final WebClient localApiClient = WebClient.create("http://localhost:8083");

    public EventPublisher() {
    }

    public Boolean publishCreateBookingEvent(CreateBookingEvent event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/createBookingEvent/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), CreateBookingEvent.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean publishCancelBookingEvent(CancelBookingEvent event) {
        System.out.println(event);
        return localApiClient
                .post()
                .uri("/createBookingEvent/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(event), CancelBookingEvent.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
