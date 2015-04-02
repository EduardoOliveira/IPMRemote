package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

public class TextInsertedEvent extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.NavigationEventHandler";
    private String text;

    public TextInsertedEvent() {
        super(null,HANDLER);
    }

    public TextInsertedEvent(String uuid,String text) {
        super(uuid,HANDLER);
        this.text = text;
    }

    public TextInsertedEvent(String uuid,String handler, String text) {
        super(uuid,handler);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
