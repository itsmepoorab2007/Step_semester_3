// ASSIGNMENT QUESTION 1: The Hostel Laundry Queue
abstract class WashType {
    private String name;
    private int durationMinutes;
    private double charge;

    public WashType(String name, int durationMinutes, double charge) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.charge = charge;
    }

    public String getName() { return name; }
    public int getDurationMinutes() { return durationMinutes; }
    public double getCharge() { return charge; }
}

class QuickWash extends WashType {
    public QuickWash() { super("Quick", 30, 20.00); }
}

class NormalWash extends WashType {
    public NormalWash() { super("Normal", 45, 30.00); }
}

class HeavyWash extends WashType {
    public HeavyWash() { super("Heavy", 60, 45.00); }
}

class WashingMachine {
    private String machineId;
    private boolean busy = false;

    public WashingMachine(String machineId) { this.machineId = machineId; }
    public String getMachineId() { return machineId; }
    public boolean isBusy() { return busy; }
    public void setBusy(boolean busy) { this.busy = busy; }
}

public class HostelLaundryQueue {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        // Asha starts Quick wash on M1
        WashType quick = new QuickWash();
        m1.setBusy(true);
        System.out.println("Quick wash started on M1 for Asha (" + quick.getDurationMinutes() + " min). Charge: " + quick.getCharge() + "0.");

        // Ravi attempts Heavy wash on M1
        if (m1.isBusy()) {
            System.out.println("Machine M1 is currently busy.");
        }

        // Ravi starts Heavy wash on M2
        WashType heavy = new HeavyWash();
        m2.setBusy(true);
        System.out.println("Heavy wash started on M2 for Ravi (" + heavy.getDurationMinutes() + " min). Charge: " + heavy.getCharge() + "0.");

        // M1 completes cycle
        m1.setBusy(false);
        System.out.println("M1 cycle completed. M1 is now free.");

        // Neha starts Normal wash on M1
        WashType normal = new NormalWash();
        m1.setBusy(true);
        System.out.println("Normal wash started on M1 for Neha (" + normal.getDurationMinutes() + " min). Charge: " + normal.getCharge() + "0.");
    }
}
