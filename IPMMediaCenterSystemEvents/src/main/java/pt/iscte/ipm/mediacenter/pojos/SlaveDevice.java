package pt.iscte.ipm.mediacenter.pojos;

public class SlaveDevice {
    private String masterAddress;
    private String name;
    private String uuid;


    public SlaveDevice() {
    }

    public SlaveDevice(String masterAddress, String name,String uuid) {
        this.masterAddress = masterAddress;
        this.name = name;
        this.uuid = uuid;
    }

    public String getMasterAddress() {
        return masterAddress;
    }

    public void setMasterAddress(String masterAddress) {
        this.masterAddress = masterAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
