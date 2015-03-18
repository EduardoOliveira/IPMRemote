package pt.iscte.ipm.mediacenter.pojos;

public class PlayBackDevice {
    private String name;
    private String currentlyPlaying;

    public PlayBackDevice() {

    }

    public PlayBackDevice(String name, String currentlyPlaying) {
        this.name = name;
        this.currentlyPlaying = currentlyPlaying;
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
}
