// PROBLEM 4: The Monthly Attendance Announcer
class AnnounceGymMember {
    protected String memberId;
    protected int sessionsAttended = 0;

    public AnnounceGymMember(String memberId) { this.memberId = memberId; }
    public void attendSession() { sessionsAttended++; }
    public int getSessionsAttended() { return sessionsAttended; }

    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }
}

class AnnouncePremiumMember extends AnnounceGymMember {
    private String trainerName;

    public AnnouncePremiumMember(String memberId, String trainerName) {
        super(memberId);
        this.trainerName = trainerName;
    }

    public String getTrainerName() { return trainerName; }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + sessionsAttended;
    }
}

public class MonthlyAttendanceAnnouncer {
    public static String batchPrint(AnnounceGymMember[] members) {
        StringBuilder sb = new StringBuilder();
        if (members == null) return "";

        for (int i = 0; i < members.length; i++) {
            AnnounceGymMember m = members[i];
            if (m == null) continue;

            sb.append(m.displayInfo());

            if (m instanceof AnnouncePremiumMember) {
                AnnouncePremiumMember pm = (AnnouncePremiumMember) m;
                sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            }

            if (i < members.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AnnounceGymMember[] list = {
            new AnnounceGymMember("MEM6"),
            new AnnouncePremiumMember("MEM7", "Coach Riya")
        };
        System.out.println(batchPrint(list));
    }
}
