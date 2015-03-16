package pt.iscte.ipm.mediacenter.remote.services.websocket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import pt.iscte.ipm.mediacenter.core.events.Event;

import java.io.IOException;

public class EventWrapper {

    private String type;
    private Event event;

    public EventWrapper() {
    }

    public EventWrapper(Event event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public Event getEvent() {
        return event;
    }

    @JsonProperty("data")
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    public void setEvent(Event event) {
        this.event = event;
        this.type = event.getClass().getCanonicalName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
