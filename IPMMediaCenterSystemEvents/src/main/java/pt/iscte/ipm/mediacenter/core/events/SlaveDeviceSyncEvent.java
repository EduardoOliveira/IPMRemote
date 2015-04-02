package pt.iscte.ipm.mediacenter.core.events;

import pt.iscte.ipm.mediacenter.pojos.SlaveDevice;

import java.util.List;

public class SlaveDeviceSyncEvent extends Event {
    private List<SlaveDevice> slaves;

    public SlaveDeviceSyncEvent() {
        super(null);
    }

    public SlaveDeviceSyncEvent(String uuid, List<SlaveDevice> slaves) {
        super(uuid);
        this.slaves = slaves;
    }

    public SlaveDeviceSyncEvent(String uuid, String handler, List<SlaveDevice> slaves) {
        super(uuid, handler);
        this.slaves = slaves;
    }

    public SlaveDeviceSyncEvent(List<SlaveDevice> slaves) {
        super(null);
        this.slaves = slaves;
    }

    public List<SlaveDevice> getSlaveDevices() {
        return slaves;
    }

    public void setSlaveDevices(List<SlaveDevice> slaves) {
        this.slaves = slaves;
    }
}
