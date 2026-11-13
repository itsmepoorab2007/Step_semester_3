// SECTION 1: Abstract Classes - Abstract Methods and Rules
public abstract class Device {
    private String deviceId;
    private boolean powerOn;

    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.powerOn = false;
    }

    public void turnOn() {
        powerOn = true;
        System.out.println(deviceId + " is now ON");
    }

    public void turnOff() {
        powerOn = false;
        System.out.println(deviceId + " is now OFF");
    }

    public String getDeviceId() {
        return deviceId;
    }

    public abstract void performPrimaryAction();
}

class SmartLight extends Device {
    public SmartLight(String deviceId) {
        super(deviceId);
    }

    @Override
    public void performPrimaryAction() {
        System.out.println(getDeviceId() + " is glowing at 100% brightness");
    }
}
