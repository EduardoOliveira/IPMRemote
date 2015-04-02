package pt.iscte.ipm.mediacenter.pojos;

import java.net.InetSocketAddress;

public class PlayBackDevice {
    private String name;
    private String currentlyPlaying;
    private String uuid;

    public PlayBackDevice() {

    }

    public PlayBackDevice(String name, String currentlyPlaying) {
        this.name = name;
        this.currentlyPlaying = currentlyPlaying;
    }

    public PlayBackDevice(String name, String currentlyPlaying, String uuid) {
        this.name = name;
        this.currentlyPlaying = currentlyPlaying;
        this.uuid = uuid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentlyPlaying() {
        return currentlyPlaying;
    }

    public void setCurrentlyPlaying(String currentlyPlaying) {
        this.currentlyPlaying = currentlyPlaying;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
