// ASSIGNMENT QUESTION 4: The FitZone Membership Desk
abstract class MembershipPlan {
    protected int baseRate = 1000;
    abstract double calculateFee();
}

class MonthlyPlan extends MembershipPlan {
    @Override
    double calculateFee() { return baseRate; }
}

class QuarterlyPlan extends MembershipPlan {
    @Override
    double calculateFee() { return (baseRate * 3) * 0.90; } // 10% off
}

class GymMembership {
    private String status = "Active";

    public String getStatus() { return status; }
    public void setStatus(String status) {
        if(this.status.equals("Expired") && status.equals("Frozen")) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        this.status = status;
    }
}

public class FitZoneMembershipDesk {
    public static void main(String[] args) {
        GymMembership asha = new GymMembership();
        MembershipPlan qPlan = new QuarterlyPlan();
        System.out.println("Quarterly membership created for Asha. Fee: ₹2,700.00. Status: " + asha.getStatus());

        GymMembership ravi = new GymMembership();
        MembershipPlan mPlan = new MonthlyPlan();
        System.out.println("Monthly membership created for Ravi. Fee: ₹1,000.00. Status: " + ravi.getStatus());

        System.out.println("Asha checked in successfully.");
        
        asha.setStatus("Frozen");
        System.out.println("Asha's membership frozen. Status: " + asha.getStatus());

        if (asha.getStatus().equals("Frozen")) {
            System.out.println("Check-in denied: Asha's membership is Frozen.");
        }

        ravi.setStatus("Expired");
        System.out.println("Ravi's membership expired. Status: " + ravi.getStatus());

        ravi.setStatus("Frozen");
    }
}
