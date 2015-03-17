package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

public class NavigationEvent extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.NavigationEventHandler";
    private String eventCode;

    public NavigationEvent() {
        super(HANDLER);
    }

    public NavigationEvent(String eventCode) {
        super(HANDLER);
        this.eventCode = eventCode;
    }

    public NavigationEvent(String handler, String eventCode) {
        super(handler);
        this.eventCode = eventCode;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }


    @Override
    public String toString() {
        return "NavigationEvent{" +
                "eventCode='" + eventCode + '\'' +
                '}';
    }

}
