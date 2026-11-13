// PROBLEM 1: Gym Membership Foundation & Batch Trial Sign-up Validator
public class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: must be at least 4 characters and non-blank.");
        }
        this.memberId = memberId.trim();
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;
    }
}

class PremiumMember extends GymMember {
    protected String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

public class GymMemberFoundationValidator {
    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        if (memberIds == null) {
            return "Signed Up: 0 | Rejected: 0";
        }

        for (String id : memberIds) {
            try {
                GymMember m = new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {
        System.out.println(signUpBatch(new String[]{"MEM1", "GM1", "MEM2", "", "MEM3"}, 1000));
    }
}
