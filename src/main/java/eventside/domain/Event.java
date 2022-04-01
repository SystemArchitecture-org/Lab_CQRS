package eventside.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {

    private final long timestamp;

    protected Event(){
        this.timestamp = System.currentTimeMillis();
    }

    //    private String customer;
//    private long timestamp;
//    private String content;
//
//    public String getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(String customer) {
//        this.customer = customer;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(long timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "Event{" +
//                "customer='" + customer + '\'' +
//                ", timestamp=" + timestamp +
//                ", content='" + content + '\'' +
//                '}';
//    }
}
