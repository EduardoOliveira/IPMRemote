package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;
import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;

public class PlayBackDeviceSelectionEvent extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.PlayBackDeviceSelectionEventHandler";
    private PlayBackDevice selectedPlayBackDevice;

    public PlayBackDeviceSelectionEvent(PlayBackDevice selectedPlayBackDevice) {
        super(HANDLER);
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }

    public PlayBackDevice getSelectedPlayBackDevice() {
        return selectedPlayBackDevice;
    }

    public void setSelectedPlayBackDevice(PlayBackDevice selectedPlayBackDevice) {
        this.selectedPlayBackDevice = selectedPlayBackDevice;
    }
}
