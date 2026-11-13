// PROBLEM 3: The Premium Loyalty Discount & Late-Fee Ledger
class FeeGymMember {
    protected String memberId;
    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    public FeeGymMember(String memberId) {
        this.memberId = memberId;
    }

    protected void chargeLateFee(int amount) {
        if (amount > 0 && feeCount < lateFeeHistory.length) {
            lateFeeHistory[feeCount++] = amount;
        }
    }

    public int[] getLateFeeHistory() {
        int[] copy = new int[feeCount];
        System.arraycopy(lateFeeHistory, 0, copy, 0, feeCount);
        return copy;
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < feeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }
}

class LedgerPremiumMember extends FeeGymMember {
    private String trainerName;

    public LedgerPremiumMember(String memberId, String trainerName) {
        super(memberId);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class PremiumMemberLateFeeLedger {
    public static void main(String[] args) {
        LedgerPremiumMember p = new LedgerPremiumMember("MEM5", "Coach Riya");
        p.chargeLateFee(200);
        System.out.println("Total Late Fees: " + p.getTotalLateFees());
    }
}
