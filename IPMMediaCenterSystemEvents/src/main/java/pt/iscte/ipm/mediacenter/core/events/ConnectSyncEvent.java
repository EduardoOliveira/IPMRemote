package pt.iscte.ipm.mediacenter.core.events;

public class ConnectSyncEvent extends Event{
    public ConnectSyncEvent() {
        super(null);
    }

    public ConnectSyncEvent(String uuid) {
        super(null);
        this.uuid = uuid;
    }

    public ConnectSyncEvent(String uuid,String handler) {
        super(uuid,handler);
    }
}
