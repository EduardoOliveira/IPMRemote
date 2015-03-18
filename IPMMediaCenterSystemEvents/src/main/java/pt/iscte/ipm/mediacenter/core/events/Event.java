package pt.iscte.ipm.mediacenter.core.events;

public abstract class Event {

    protected String handler;

    public Event() {
    }

    public Event(String handler) {
        this.handler = handler;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
