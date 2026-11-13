// SECTION 2: Multilevel and Hierarchical Inheritance
class EventTicketBase {
    protected double basePrice;
    protected double amountPaid;
    public EventTicketBase(double basePrice) { this.basePrice = basePrice; }
}

class WorkshopTicketTier extends EventTicketBase {
    protected String track;
    public WorkshopTicketTier(double basePrice, String track) {
        super(basePrice);
        this.track = track;
    }
}

class PremiumWorkshopTicket extends WorkshopTicketTier {
    private double kitFee;

    public PremiumWorkshopTicket(double basePrice, String track, double kitFee) {
        super(basePrice, track);
        this.kitFee = kitFee;
    }

    public double getBalanceDue() {
        return basePrice + kitFee;
    }
}

public class MultilevelHierarchicalDemo {
    public static void main(String[] args) {
        PremiumWorkshopTicket p = new PremiumWorkshopTicket(2000, "Cloud Native", 300);
        System.out.println("Base + Kit Fee model ready.");
    }
}
