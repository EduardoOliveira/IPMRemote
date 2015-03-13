package pt.iscte.ipm.mediacenter.remote.events;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pt.iscte.ipm.mediacenter.remote.events.Event;

public class ConnectEvent extends Event{
    @JsonIgnore
    private static final String MASTER_TYPE="pt.iscte.ipm.mediacenter.websocket.events.ConnectEvent";
    private static final String deviceType = "pt.iscte.ipm.mediacenter.remote.devices.RemoteControl";
    private String deviceName;

    public ConnectEvent(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }


    @JsonIgnore
    @Override
    public String getEventMasterType() {
        return MASTER_TYPE;
    }
}
