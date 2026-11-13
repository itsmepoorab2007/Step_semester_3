// SECTION 7: final Fields and Encapsulation (Defensive Copying)
public class CourseRoster {
    private final String courseCode;
    private final int[] scores;

    public CourseRoster(String courseCode, int[] scores) {
        this.courseCode = courseCode;
        this.scores = scores.clone(); // Defensive copy IN
    }

    public int[] getScores() {
        return scores.clone(); // Defensive copy OUT
    }
}
