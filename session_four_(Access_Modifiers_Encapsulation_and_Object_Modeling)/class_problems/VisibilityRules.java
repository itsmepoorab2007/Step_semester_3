// SECTION 2: Visibility Rules Across Packages and Inheritance
package srm.fees;

public class FeeAccountBase {
    protected double amountPaid;
    private String internalAuditCode; // never leaves this class, ever

    protected void applyLatePenalty(double amount) {
        amountPaid -= amount;
    }
}

class HostelFeeAccount extends FeeAccountBase {
    public void chargeLateFine(double amount) {
        applyLatePenalty(amount); // OK -- protected, reached through inheritance
        amountPaid += 0;          // OK -- protected field, same reasoning
        // System.out.println(internalAuditCode); -- COMPILE ERROR, private
    }
}
