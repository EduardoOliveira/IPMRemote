package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;

public class PlayBackDeviceSelectionEvent extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.PlayBackDeviceSelectionEventHandler";
    private PlayBackDevice selectedPlayBackDevice;

    public PlayBackDeviceSelectionEvent() {
        super(HANDLER);
    }

    public PlayBackDeviceSelectionEvent(PlayBackDevice selectedPlayBackDevice) {
        super(null, HANDLER);
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }

    public PlayBackDeviceSelectionEvent(String uuid, PlayBackDevice selectedPlayBackDevice) {
        super(uuid, HANDLER);
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }

    public PlayBackDeviceSelectionEvent(String uuid, String handler, PlayBackDevice selectedPlayBackDevice) {
        super(uuid, handler);
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }

    public PlayBackDevice getSelectedPlayBackDevice() {
        return selectedPlayBackDevice;
    }

    public void setSelectedPlayBackDevice(PlayBackDevice selectedPlayBackDevice) {
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }
}