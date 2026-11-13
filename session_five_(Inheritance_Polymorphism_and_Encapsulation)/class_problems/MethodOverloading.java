// SECTION 6: Compile-Time Polymorphism - Method Overloading
class OverloadedTicket {
    protected double amountPaid;

    public void pay(double amount) {
        if (amount > 0) amountPaid += amount;
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        OverloadedTicket t = new OverloadedTicket();
        t.pay(200, "UPI");
        System.out.println("Amount paid: " + t.amountPaid);
    }
}
