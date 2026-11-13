// SECTION 4: IS-A vs CAN-DO
class BasicLamp extends Device {
    public BasicLamp(String deviceId) {
        super(deviceId);
    }

    @Override
    public void performPrimaryAction() {
        System.out.println(getDeviceId() + " is simply lit, nothing fancy");
    }
}

public class IsAVsCanDoDemo {
    public static void main(String[] args) {
        BasicLamp lamp = new BasicLamp("LAMP-01");
        lamp.turnOn();
        lamp.performPrimaryAction();
    }
}
