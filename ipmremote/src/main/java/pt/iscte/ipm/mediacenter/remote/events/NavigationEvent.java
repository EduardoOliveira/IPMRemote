package pt.iscte.ipm.mediacenter.remote.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pt.iscte.ipm.mediacenter.remote.events.Event;

public class NavigationEvent extends Event {
    @JsonIgnore
    private static final String MASTER_TYPE = "pt.iscte.ipm.mediacenter.remote.events.NavigationEvent";

    private String keyCode;

    public NavigationEvent() {
    }

    public NavigationEvent(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    @Override
    public String toString() {
        return "NavigationEvent{" +
                "keyCode='" + keyCode + '\'' +
                '}';
    }

    @Override
    public String getEventMasterType() {
        return MASTER_TYPE;
    }
}
