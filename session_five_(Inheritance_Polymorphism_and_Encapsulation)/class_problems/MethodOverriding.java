// SECTION 4: Method Overriding (@Override)
class TicketBase {
    protected double amountPaid;

    protected void applyLateRegistrationFee(double amount) {
        amountPaid += amount;
    }
}

class OverriddenWorkshopTicket extends TicketBase {
    @Override
    protected void applyLateRegistrationFee(double amount) {
        super.applyLateRegistrationFee(amount * 2); // extend parent behavior
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {
        OverriddenWorkshopTicket w = new OverriddenWorkshopTicket();
        w.applyLateRegistrationFee(100);
        System.out.println("Amount paid after doubled late fee: " + w.amountPaid);
    }
}
