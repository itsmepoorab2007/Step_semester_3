// QUESTION 1: Vehicle Rental System
abstract class Vehicle {
    private String vehicleId;
    private boolean isAvailable;
    protected double dailyRate;

    public Vehicle(String vehicleId, double dailyRate) {
        this.vehicleId = vehicleId;
        this.dailyRate = dailyRate;
        this.isAvailable = true;
    }

    public String getVehicleId() { return vehicleId; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public abstract double calculateRentalCharge(int days);
}

class Sedan extends Vehicle {
    public Sedan(String vehicleId, double dailyRate) {
        super(vehicleId, dailyRate);
    }
    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleId, double dailyRate) {
        super(vehicleId, dailyRate);
    }
    @Override
    public double calculateRentalCharge(int days) {
        return (dailyRate * days) * 1.15; // SUV surcharge
    }
}

class Customer {
    private String name;
    public Customer(String name) { this.name = name; }
    public String getName() { return name; }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;

    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        vehicle.setAvailable(false);
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    
    public void returnVehicle() {
        vehicle.setAvailable(true);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle sedanA = new Sedan("Sedan A", 100.0);
        Vehicle suvB = new SUV("SUV B", 150.0);
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        // Customer 1 rents Sedan A
        if (sedanA.isAvailable()) {
            Rental r1 = new Rental(c1, sedanA, 3);
            System.out.println("Sedan A rented successfully by " + c1.getName() + ". Rental charge: $" + sedanA.calculateRentalCharge(3));
        }

        // Customer 2 attempts to rent Sedan A
        if (!sedanA.isAvailable()) {
            System.out.println("Sedan A is currently unavailable.");
        }

        // Customer 1 returns Sedan A
        sedanA.setAvailable(true);
        System.out.println("Sedan A returned by " + c1.getName());

        // Customer 3 rents SUV B
        if (suvB.isAvailable()) {
            Rental r3 = new Rental(c3, suvB, 5);
            System.out.println("SUV B rented successfully by " + c3.getName() + ". Rental charge: $" + suvB.calculateRentalCharge(5));
        }
    }
}
