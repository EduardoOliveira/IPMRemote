package pt.iscte.ipm.mediacenter.remote.core.logic;

import android.util.Log;
import pt.iscte.ipm.mediacenter.pojos.PlayBackDevice;

import java.util.ArrayList;
import java.util.List;

public class PlayBackDeviceManager {
    private static PlayBackDeviceManager ourInstance = new PlayBackDeviceManager();
    private List<PlayBackDevice> playBackDevices = new ArrayList<>();
    private PlayBackDevice selected;


    public static PlayBackDeviceManager getInstance() {
        return ourInstance;
    }

    private PlayBackDeviceManager() {
    }

    public List<PlayBackDevice> getPlayBackDevices() {
        return playBackDevices;
    }

    public void setPlayBackDevices(List<PlayBackDevice> playBackDevices) {
        this.playBackDevices = playBackDevices;
        Log.d("device size", this.playBackDevices.size() + "");
    }

    public void setSelected(int selected) {
        this.selected = playBackDevices.get(selected);
    }

    public PlayBackDevice getSelected() {
        return selected;
    }
}
