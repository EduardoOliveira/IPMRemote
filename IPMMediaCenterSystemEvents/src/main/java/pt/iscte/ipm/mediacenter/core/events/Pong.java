package pt.iscte.ipm.mediacenter.core.events;

public class Pong extends Event {
    private long timeStamp;

    public Pong() {
    }

    public Pong(long timeStamp) {
        super();
        this.timeStamp = timeStamp;
    }

    public Pong(String uuid, long timeStamp) {
        super(uuid);
        this.timeStamp = timeStamp;
    }

    public Pong(String uuid, String handler, long timeStamp) {
        super(uuid, handler);
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
