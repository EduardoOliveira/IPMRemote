package pt.iscte.ipm.mediacenter.core.events;

public abstract class Event {

    protected String handler;
    protected String uuid;

    public Event() {
    }

    public Event(String uuid) {
        this.uuid = uuid;
    }

    public Event(String uuid, String handler) {
        this.handler = handler;
        this.uuid = uuid;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
