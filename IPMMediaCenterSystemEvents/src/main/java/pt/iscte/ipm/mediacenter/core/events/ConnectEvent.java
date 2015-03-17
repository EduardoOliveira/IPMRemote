package pt.iscte.ipm.mediacenter.core.events;

public class ConnectEvent extends Event {
    private String deviceType;
    private String deviceName;

    public ConnectEvent() {
    }

    public ConnectEvent(String deviceName) {
        this.deviceName = deviceName;
    }

    public ConnectEvent(String deviceType, String deviceName) {
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
