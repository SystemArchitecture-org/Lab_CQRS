package eventside.domain;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Subscriber {
    private final WebClient client;

    public Subscriber(WebClient client) {
        this.client = client;
    }

    public static Subscriber create(String host) {
        return new Subscriber(WebClient.create(host));
    }

    public void notify(Event event) {
        String uri = event.uri();

        if (uri != null) {
            client.post()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .body(Mono.just(event), Event.class)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        }

    }
}
