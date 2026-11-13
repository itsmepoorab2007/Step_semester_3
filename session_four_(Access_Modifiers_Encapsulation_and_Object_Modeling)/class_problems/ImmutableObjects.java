// SECTION 6: Immutable Objects
public final class EnrollmentRecord {
    private final String regNo;
    private final String course;
    private final int enrollmentYear;

    public EnrollmentRecord(String regNo, String course, int enrollmentYear) {
        this.regNo = regNo;
        this.course = course;
        this.enrollmentYear = enrollmentYear;
    }

    public String getRegNo() { return regNo; }
    public String getCourse() { return course; }
    public int getEnrollmentYear() { return enrollmentYear; }

    public EnrollmentRecord withCourse(String newCourse) {
        return new EnrollmentRecord(this.regNo, newCourse, this.enrollmentYear);
    }
}
