package pt.iscte.ipm.mediacenter.core.events;


public class ConnectEvent extends Event {
    private String deviceName;

    public ConnectEvent() {
        super();
    }

    public ConnectEvent(String handler) {
        super(handler);
    }

    public ConnectEvent(String deviceName, String handler) {
        super(handler);
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
