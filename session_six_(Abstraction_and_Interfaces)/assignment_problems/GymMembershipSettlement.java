// PROBLEM 5: Membership Numbers, Referral Codes & the Weekly Check-in Settlement
public class SettlementGymMember {
    private static int counter = 2000;
    protected final String membershipNumber;
    protected int monthlyFee;
    protected int feesPaid = 0;

    public SettlementGymMember(int monthlyFee) {
        counter++;
        this.membershipNumber = "GYM-" + counter;
        this.monthlyFee = monthlyFee;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public static int getMembersEnrolled() {
        return counter - 2000;
    }

    public void payFee(int amount) {
        if (amount > 0) {
            feesPaid += amount;
        }
    }

    public void payFee(int amount, String mode) {
        System.out.println("Paid via " + mode);
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }
}

class SettlementGroupClassMember extends SettlementGymMember {
    private String className;

    public SettlementGroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}

public class GymMembershipSettlement {
    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static String processWeeklyCheckIn(SettlementGymMember[] members) {
        int regularCount = 0;
        int groupCount = 0;
        int nullCount = 0;

        if (members == null) {
            return "0 processed | 0 null skipped | 0 group 0 individual";
        }

        for (SettlementGymMember m : members) {
            if (m == null) {
                nullCount++;
                continue;
            }
            if (m instanceof SettlementGroupClassMember) {
                groupCount++;
            } else {
                regularCount++;
            }
        }

        int totalProcessed = regularCount + groupCount;
        return totalProcessed + " processed | " + nullCount + " null skipped | " + groupCount + " group " + regularCount + " individual";
    }

    public static void main(String[] args) {
        SettlementGymMember[] batch = {
            new SettlementGroupClassMember(1500, "Zumba"),
            null,
            new SettlementGymMember(1000)
        };
        System.out.println(processWeeklyCheckIn(batch));
    }
}
