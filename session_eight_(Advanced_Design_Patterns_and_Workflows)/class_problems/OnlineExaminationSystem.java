// QUESTION 3: Online Examination System
abstract class Question {
    private String text;
    private int points;

    public Question(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public int getPoints() { return points; }
    public abstract boolean evaluate(String studentAnswer);
}

class MCQQuestion extends Question {
    private String correctAnswer;

    public MCQQuestion(String text, int points, String correctAnswer) {
        super(text, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String studentAnswer) {
        return correctAnswer.equalsIgnoreCase(studentAnswer.trim());
    }
}

class Attempt {
    private boolean submitted = false;
    public boolean isSubmitted() { return submitted; }
    public void submit() { this.submitted = true; }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        MCQQuestion q1 = new MCQQuestion("What is 2+2?", 5, "C");
        Attempt attempt = new Attempt();
        
        System.out.println("Exam A started by Student 1.");
        System.out.println("Answer recorded for Question 1.");
        
        attempt.submit();
        System.out.println("Exam A submitted by Student 1.");
        
        if (attempt.isSubmitted()) {
            System.out.println("Cannot change answers for a submitted examination.");
        }
    }
}
