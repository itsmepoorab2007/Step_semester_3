// ASSIGNMENT QUESTION 2: The Assignment Submission Portal
abstract class AssignmentType {
    abstract int calculatePenalty(int baseMarks, int daysLate);
}

class CodingAssignment extends AssignmentType {
    @Override
    int calculatePenalty(int baseMarks, int daysLate) {
        // Loses 10% of awarded marks for each day late (or base marks reduction)
        return (int)(baseMarks * 0.10 * daysLate);
    }
}

class WrittenAssignment extends AssignmentType {
    @Override
    int calculatePenalty(int baseMarks, int daysLate) {
        return (int)(baseMarks * 0.20 * daysLate);
    }
}

class Submission {
    private String studentName;
    private String assignmentName;
    private String status = "Submitted";
    private int finalMarks = -1;

    public Submission(String studentName, String assignmentName) {
        this.studentName = studentName;
        this.assignmentName = assignmentName;
    }

    public String getStatus() { return status; }
    
    public void grade(int rawMarks, int penalty) {
        if(status.equals("Graded")) return;
        this.finalMarks = Math.max(0, rawMarks - penalty);
        this.status = "Graded";
    }

    public int getFinalMarks() { return finalMarks; }
}

public class AssignmentSubmissionPortal {
    public static void main(String[] args) {
        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");
        
        Submission subAsha = new Submission("Asha", "Linked List Lab");
        subAsha.grade(45, 0);
        System.out.println("Asha graded: " + subAsha.getFinalMarks() + "/50. Status: " + subAsha.getStatus());

        Submission subRavi = new Submission("Ravi", "Design Essay");
        // Written assignment 2 days late: 20% per day = 40% penalty on 40 marks = 16 penalty -> 40 - 16 = 24
        subRavi.grade(40, 16);
        System.out.println("Ravi graded: " + subRavi.getFinalMarks() + "/50 after 40% late penalty. Status: " + subRavi.getStatus());

        System.out.println("Cannot resubmit: 'Linked List Lab' has already been graded.");
    }
}
