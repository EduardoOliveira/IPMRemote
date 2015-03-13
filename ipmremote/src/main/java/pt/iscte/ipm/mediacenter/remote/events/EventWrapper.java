package pt.iscte.ipm.mediacenter.remote.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class EventWrapper {



    @JsonProperty("data")
    private Event event;

    @JsonProperty("event")
    private String type;

    public EventWrapper(Event event) {
        this.event = event;
        this.type = event.getEventMasterType();
    }

    public Event getEvent() {
        return event;
    }

    @JsonIgnore
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    public void setEvent(Event event) {
        this.event = event;
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
