// SECTION 2: Interfaces - Complete Abstraction and Multiple Inheritance
public interface Remoteable {
    void connectToApp(String appId);
}

public interface Schedulable {
    void scheduleAction(String time);
}

public interface EnergyMonitorable {
    double getPowerConsumption();
}

class SmartThermostat extends Device implements Remoteable, Schedulable, EnergyMonitorable {
    private double targetTemp;

    public SmartThermostat(String deviceId, double targetTemp) {
        super(deviceId);
        this.targetTemp = targetTemp;
    }

    @Override
    public void performPrimaryAction() {
        System.out.println(getDeviceId() + " is regulating temperature to " + targetTemp + " degrees");
    }

    @Override
    public void connectToApp(String appId) {
        System.out.println(getDeviceId() + " connected to app: " + appId);
    }

    @Override
    public void scheduleAction(String time) {
        System.out.println(getDeviceId() + " scheduled for: " + time);
    }

    @Override
    public double getPowerConsumption() {
        return 45.5;
    }
}

class SmartDoorLock implements Remoteable {
    private String lockId;

    public SmartDoorLock(String lockId) {
        this.lockId = lockId;
    }

    @Override
    public void connectToApp(String appId) {
        System.out.println(lockId + " connected to app: " + appId);
    }
}
