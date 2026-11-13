// SECTION 3: Encapsulation (Data Hiding With Private Fields and Public Methods)
class FeeAccountEncapsulated {
    private double totalFee;
    private double amountPaid;

    public FeeAccountEncapsulated(double totalFee) {
        this.totalFee = totalFee;
        this.amountPaid = 0.0;
    }

    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("Payment rejected: must be positive");
            return;
        }
        amountPaid += amount;
    }

    public double getDue() {
        return totalFee - amountPaid;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        FeeAccountEncapsulated acc = new FeeAccountEncapsulated(100000);
        acc.pay(25000);
        System.out.println("Remaining due: " + acc.getDue());
    }
}
