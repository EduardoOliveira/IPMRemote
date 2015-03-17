package pt.iscte.ipm.mediacenter.core.events;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ConnectEvent extends Event {
    private String deviceType;
    private String deviceName;
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.websocket.handling.ConnectEventHandler";

    public ConnectEvent() {
        super(HANDLER);
    }

    public ConnectEvent(String deviceName) {
        super(HANDLER);
        this.deviceName = deviceName;
    }

    public ConnectEvent(String deviceType, String deviceName) {
        super(HANDLER);
        this.deviceType = deviceType;
        this.deviceName = deviceName;
    }

    public ConnectEvent(String handler, String deviceType, String deviceName) {
        super(handler);
        this.deviceType = deviceType;
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}
