package pt.iscte.ipm.mediacenter.remote.services.websocket.events;



public class TextRemoteEvent extends RemoteEvent {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
