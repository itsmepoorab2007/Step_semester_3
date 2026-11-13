// PROBLEM 2: Three Tiers of Gym Membership
class BaseGymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public BaseGymMember(String memberId, int monthlyFee) {
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() { sessionsAttended++; }
    public int getSessionsAttended() { return sessionsAttended; }
    public String displayInfo() { return "Standard Member | Sessions: " + sessionsAttended; }
}

class TieredPremiumMember extends BaseGymMember {
    protected String trainerName;
    public TieredPremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }
    @Override
    public String displayInfo() { return "Premium Member Trainer: " + trainerName + " | Sessions: " + sessionsAttended; }
}

class EliteMember extends TieredPremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + sessionsAttended;
    }
}

class GroupClassMember extends BaseGymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member Class: " + className + " | Sessions: " + sessionsAttended;
    }
}

public class GymMembershipTiers {
    public static String classifyGeneration(BaseGymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof TieredPremiumMember) {
            return "Direct child (2 generations deep)";
        } else {
            return "Base root class";
        }
    }

    public static int getTotalSessionsAttended(BaseGymMember[] members) {
        int total = 0;
        if (members == null) return 0;
        for (BaseGymMember m : members) {
            if (m != null) {
                total += m.getSessionsAttended();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        EliteProviderDemo.runDemo();
    }
}

class EliteProviderDemo {
    public static void runDemo() {
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        System.out.println(elite.displayInfo());
    }
}
