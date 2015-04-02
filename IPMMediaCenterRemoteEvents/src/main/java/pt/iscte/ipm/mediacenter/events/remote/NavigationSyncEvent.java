package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

import java.util.logging.Handler;

public class NavigationSyncEvent extends Event{
    private String eventCode;

    public NavigationSyncEvent() {
        super(null);
    }

    public NavigationSyncEvent(String eventCode) {
        super(null);
        this.eventCode = eventCode;
    }

    public NavigationSyncEvent(String uuid, String eventCode){
        super(uuid);
        this.eventCode = eventCode;
    }

    public NavigationSyncEvent(String uuid,String handler, String eventCode) {
        super(uuid,handler);
        this.eventCode = eventCode;
    }

    public NavigationSyncEvent(NavigationEvent navigationEvent) {
        super(null);
        this.eventCode = navigationEvent.getEventCode();
    }

    public NavigationSyncEvent(String uuid,NavigationEvent navigationEvent) {
        super(uuid);
        this.eventCode = navigationEvent.getEventCode();
    }

    public NavigationSyncEvent(String uuid,String handler,NavigationEvent navigationEvent) {
        super(uuid,handler);
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
