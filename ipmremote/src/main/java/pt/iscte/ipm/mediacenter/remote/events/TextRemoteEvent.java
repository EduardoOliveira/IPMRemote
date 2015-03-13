package pt.iscte.ipm.mediacenter.remote.events;


import com.fasterxml.jackson.annotation.JsonIgnore;
import pt.iscte.ipm.mediacenter.remote.events.Event;

public class TextRemoteEvent extends Event {
    @JsonIgnore
    private static final String MASTER_TYPE = "pt.iscte.ipm.mediacenter.remote.events.TextInsertedEvent";
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getEventMasterType() {
        return MASTER_TYPE;
    }
}
