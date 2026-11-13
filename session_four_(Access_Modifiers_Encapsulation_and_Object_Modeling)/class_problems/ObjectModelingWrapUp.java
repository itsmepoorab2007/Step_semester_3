// WRAP-UP: Object Modeling Putting It All Together
public final class SrmStudentProfile {
    private final String regNo;
    private final String name;
    private double attendance;

    public SrmStudentProfile(String regNo, String name, double attendance) {
        this.regNo = regNo;
        this.name = name;
        this.attendance = attendance;
    }

    public String getRegNo() { return regNo; }
    public String getName() { return name; }
    public double getAttendance() { return attendance; }

    public void setAttendance(double attendance) {
        if (attendance < 0 || attendance > 100) {
            System.out.println("Rejected: attendance must be 0-100");
            return;
        }
        this.attendance = attendance;
    }
}
