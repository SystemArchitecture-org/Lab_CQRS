package eventside.infrastructure;

import eventside.domain.Event;
import eventside.domain.Subscriber;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class EventRepository {

    private final List<Event> events = new ArrayList<>();

    private Map<String, Subscriber> subscriber = Map.of("http://localhost:8082", Subscriber.create("http://localhost:8082"));

    public void processEvent(Event event) {
        events.add(event);
        subscriber.values().forEach(sub -> sub.notify(event));
    }

    public void attach(String host) {
        Subscriber sub = Subscriber.create(host);
        subscriber.put(host, sub);
        events.forEach(sub::notify);
    }

    public void detach(String host) {
        subscriber.remove(host);
    }
}
