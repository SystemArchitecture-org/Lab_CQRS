package eventside.domain;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.JsonSerializer;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {

    private long timestamp;

    public Event(){
        this.timestamp = System.currentTimeMillis();
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
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
