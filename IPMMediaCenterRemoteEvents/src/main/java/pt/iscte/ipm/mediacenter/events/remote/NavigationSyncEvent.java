package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

public class NavigationSyncEvent extends Event{
    private String eventCode;

    public NavigationSyncEvent() {
        super(null);
    }

    public NavigationSyncEvent(String eventCode) {
        super(null);
        this.eventCode = eventCode;
    }

    public NavigationSyncEvent(String handler, String eventCode) {
        super(handler);
        this.eventCode = eventCode;
    }

    public NavigationSyncEvent(NavigationEvent navigationEvent) {
        super(null);
        this.eventCode = navigationEvent.getEventCode();
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
