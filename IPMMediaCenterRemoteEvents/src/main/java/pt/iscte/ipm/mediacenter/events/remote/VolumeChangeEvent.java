package pt.iscte.ipm.mediacenter.events.remote;

import pt.iscte.ipm.mediacenter.core.events.Event;

/**
 * Created by nuno on 6/18/15.
 */
public class VolumeChangeEvent extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.remote.handling.VolumeChangeEventHandler";
    private int volumeProgress;

    public VolumeChangeEvent() {
        super(null,HANDLER);
    }

    public VolumeChangeEvent(String uuid,int volumeProgress) {
        super(uuid,HANDLER);
        this.volumeProgress = volumeProgress;
    }

    public VolumeChangeEvent(String uuid,String handler, int volumeProgress) {
        super(uuid,handler);
        this.volumeProgress = volumeProgress;
    }

    public int getVolumeProgress() {
        return volumeProgress;
    }

    public void setVolumeProgress(int volumeProgress) {
        this.volumeProgress = volumeProgress;
    }


    @Override
    public String toString() {
        return "VolumeChangeEvent{" +
                "eventCode='" + volumeProgress + '\'' +
                '}';
    }
}
