package pt.iscte.ipm.mediacenter.core.events;

public class DisconnectedFromPlayBackDeviceSyncEvent extends Event{
    private int code;
    private String masterUUID;

    public DisconnectedFromPlayBackDeviceSyncEvent() {
        super();
    }

    public DisconnectedFromPlayBackDeviceSyncEvent(int code,String masterUUID) {
        super();
        this.code = code;
        this.masterUUID = masterUUID;
    }

    public DisconnectedFromPlayBackDeviceSyncEvent(String uuid, int code,String masterUUID) {
        super(uuid);
        this.code = code;
        this.masterUUID = masterUUID;
    }

    public DisconnectedFromPlayBackDeviceSyncEvent(String uuid, String handler, int code,String masterUUID) {
        super(uuid, handler);
        this.code = code;
        this.masterUUID = masterUUID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMasterUUID() {
        return masterUUID;
    }

    public void setMasterUUID(String masterUUID) {
        this.masterUUID = masterUUID;
    }

    public static class Code {
        public static final int OTHER =0;
        public static final int KICKED = 10;
        public static final int MASTER_DISCONNECTED = 20;
    }
}
