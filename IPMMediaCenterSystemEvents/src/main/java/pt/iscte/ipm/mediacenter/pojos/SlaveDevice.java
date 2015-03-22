package pt.iscte.ipm.mediacenter.pojos;

public class SlaveDevice {
    private String masterAddress;
    private String name;
    private String address;


    public SlaveDevice() {
    }

    public SlaveDevice(String masterAddress, String name, String address) {
        this.masterAddress = masterAddress;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
