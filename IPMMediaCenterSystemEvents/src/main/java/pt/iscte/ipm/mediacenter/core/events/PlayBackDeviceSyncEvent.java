package pt.iscte.ipm.mediacenter.core.events;


import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;

import java.util.List;

public class PlayBackDeviceSyncEvent extends Event {
    private List<PlayBackDevice> playBackDevices;

    public PlayBackDeviceSyncEvent() {
        super(null);
    }

    public PlayBackDeviceSyncEvent(String uuid, List<PlayBackDevice> playBackDevices) {
        super(uuid);
        this.playBackDevices = playBackDevices;
    }

    public PlayBackDeviceSyncEvent(String uuid, String handler, List<PlayBackDevice> playBackDevices) {
        super(uuid, handler);
        this.playBackDevices = playBackDevices;
    }

    public PlayBackDeviceSyncEvent(List<PlayBackDevice> playBackDevices) {
        super(null);
        this.playBackDevices = playBackDevices;
    }

    public List<PlayBackDevice> getPlayBackDevices() {
        return playBackDevices;
    }

    public void setPlayBackDevices(List<PlayBackDevice> playBackDevices) {
        this.playBackDevices = playBackDevices;
    }
}
