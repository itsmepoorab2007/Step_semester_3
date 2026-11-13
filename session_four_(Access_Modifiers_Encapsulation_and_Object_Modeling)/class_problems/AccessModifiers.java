// SECTION 1: Access Modifiers (private, default, protected, public)
package srm.fees;

public class FeeAccount {
    private String regNo;
    public double totalFee;
    protected double amountPaid;
    public String accountType;

    public FeeAccount(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    public String getRegNo() {
        return regNo; // the only door into a private field
    }
}

class FeeOfficeDemo {
    public static void main(String[] args) {
        FeeAccount acc = new FeeAccount("RA2311003010123", 200000.0);
        System.out.println(acc.totalFee);             // OK -- public
        System.out.println(acc.getRegNo());          // OK -- through a public method
        // System.out.println(acc.regNo);            // COMPILE ERROR, private
    }
}
