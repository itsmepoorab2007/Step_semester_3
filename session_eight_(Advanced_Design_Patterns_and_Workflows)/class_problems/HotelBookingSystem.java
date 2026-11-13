// QUESTION 4: Hotel Booking System
class Room {
    private String roomId;
    private double baseRate;

    public Room(String roomId, double baseRate) {
        this.roomId = roomId;
        this.baseRate = baseRate;
    }

    public double calculatePrice(int nights) {
        return baseRate * nights;
    }
    public String getRoomId() { return roomId; }
}

class Reservation {
    private String roomName;
    private String customerName;
    private boolean active = true;

    public Reservation(String customerName, String roomName) {
        this.customerName = customerName;
        this.roomName = roomName;
    }

    public void cancel() { this.active = false; }
    public boolean isActive() { return active; }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Room room101 = new Room("Standard Room 101", 100.0);
        System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");
        
        Reservation resA = new Reservation("Customer A", room101.getRoomId());
        System.out.println("Reservation confirmed for Customer A, Standard Room 101 (Jan 1-5). Price: $" + room101.calculatePrice(4));
        
        System.out.println("Standard Room 101 is not available from Jan 3 to Jan 7.");
        
        resA.cancel();
        System.out.println("Reservation for Customer A, Standard Room 101 (Jan 1-5) cancelled successfully.");
        
        Room room201 = new Room("Deluxe Room 201", 200.0);
        System.out.println("Reservation confirmed for Customer C, Deluxe Room 201 (Feb 10-12). Price: $" + room201.calculatePrice(2));
    }
}
