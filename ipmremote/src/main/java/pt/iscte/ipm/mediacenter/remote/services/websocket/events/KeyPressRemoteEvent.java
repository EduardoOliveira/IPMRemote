package pt.iscte.ipm.mediacenter.remote.services.websocket.events;

public class KeyPressRemoteEvent extends RemoteEvent {
    private String keyCode;

    public KeyPressRemoteEvent(String keyCode) {
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
        return "KeyPressRemoteEvent{" +
                "keyCode='" + keyCode + '\'' +
                '}';
    }

}
