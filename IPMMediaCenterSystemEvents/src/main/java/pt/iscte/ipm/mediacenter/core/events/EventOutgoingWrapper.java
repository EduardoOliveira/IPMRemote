package pt.iscte.ipm.mediacenter.core.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class EventOutgoingWrapper {

    private String event;

    private Event data;

    public EventOutgoingWrapper() {
    }

    public EventOutgoingWrapper(Event data) {
        this.data = data;
        this.event = data.getClass().getCanonicalName();
    }

    public Event getData() {
        return data;
    }

    public void setData(Event data) {
        this.data = data;
        this.event = data.getClass().getCanonicalName();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {

        try {
            return (new ObjectMapper().writeValueAsString(this));
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
