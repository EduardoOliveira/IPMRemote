package pt.iscte.ipm.mediacenter.core.events;

public class Ping extends Event {
    private static final String HANDLER = "pt.iscte.ipm.mediacenter.core.events.PingPongHandler";
    private long timeStamp;

    public Ping() {
    }

    public Ping(long timeStamp) {
        super(null,HANDLER);
        this.timeStamp = timeStamp;
    }

    public Ping(String uuid, long timeStamp) {
        super(uuid,HANDLER);
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
