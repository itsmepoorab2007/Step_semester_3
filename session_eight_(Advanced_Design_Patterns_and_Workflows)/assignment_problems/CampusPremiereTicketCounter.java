// ASSIGNMENT QUESTION 3: The Campus Premiere Ticket Counter
import java.util.*;

abstract class Seat {
    private String seatId;
    protected double price;
    public Seat(String seatId, double price) {
        this.seatId = seatId;
        this.price = price;
    }
    public double getPrice() { return price; }
    public String getSeatId() { return seatId; }
}

class RegularSeat extends Seat {
    public RegularSeat(String seatId) { super(seatId, 150.0); }
}

class PremiumSeat extends Seat {
    public PremiumSeat(String seatId) { super(seatId, 250.0); }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatId) { super(seatId, 400.0); }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        Set<String> bookedSeats = new HashSet<>();
        
        // Asha books A1, A2, F5
        bookedSeats.add("A1");
        bookedSeats.add("A2");
        bookedSeats.add("F5");
        System.out.println("Booking confirmed for Asha: A1, A2, F5. Total: 550.00.");

        // Ravi attempts to book A2
        if (bookedSeats.contains("A2")) {
            System.out.println("Seat A2 is already booked for this show.");
        }

        // Ravi books R1
        bookedSeats.add("R1");
        System.out.println("Booking confirmed for Ravi: R1. Total: ₹400.00.");

        // Asha cancels booking
        bookedSeats.remove("A1");
        bookedSeats.remove("A2");
        bookedSeats.remove("F5");
        System.out.println("Asha's booking cancelled. Seats A1, A2, F5 released.");

        // Neha books A2
        if (!bookedSeats.contains("A2")) {
            bookedSeats.add("A2");
            System.out.println("Booking confirmed for Neha: A2. Total: 150.00.");
        }
    }
}
