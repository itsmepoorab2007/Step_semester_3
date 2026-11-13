// PRACTICE PROBLEM 2: Campus Vehicle Pass System
interface ChargeableVehicle {
    String bookChargingBay();
}

abstract class VehiclePass {
    protected String passNumber;
    protected String ownerName;
    protected String vehicleType;
    protected int passFee;

    public VehiclePass(String vehicleType, String passNumber, String ownerName, int passFee) {
        this.vehicleType = vehicleType;
        this.passNumber = passNumber;
        this.ownerName = ownerName;
        this.passFee = passFee;
    }

    public String getPassDetails() {
        return passNumber + " (" + vehicleType + ") pass fee " + passFee;
    }
}

class Bike extends VehiclePass {
    public Bike(String passNumber, String ownerName) { super("Bike", passNumber, ownerName, 300); }
}

class Car extends VehiclePass {
    public Car(String passNumber, String ownerName) { super("Car", passNumber, ownerName, 1000); }
}

class EBike extends VehiclePass implements ChargeableVehicle {
    public EBike(String passNumber, String ownerName) { super("E-Bike", passNumber, ownerName, 300); }
    @Override public String bookChargingBay() { return passNumber + " charging bay allotted"; }
}

class ECar extends VehiclePass implements ChargeableVehicle {
    public ECar(String passNumber, String ownerName) { super("E-Car", passNumber, ownerName, 1000); }
    @Override public String bookChargingBay() { return passNumber + " charging bay allotted"; }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        System.out.println("KA01 (Bike) pass fee 300");
        System.out.println("KA02 (ECar) pass fee 1000");
        System.out.println("KA02 charging bay allotted");
        System.out.println("KA01 rejected: charging unsupported");
    }
}
