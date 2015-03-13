package pt.iscte.ipm.mediacenter.remote.events;

import pt.iscte.ipm.mediacenter.remote.devices.PlayBackDevice;

import java.util.List;

public class PlayBackDeviceSyncEvent{
    private List<PlayBackDevice> playBackDevices;

    public PlayBackDeviceSyncEvent() {
    }

    public List<PlayBackDevice> getPlayBackDevices() {
        return playBackDevices;
    }

}
