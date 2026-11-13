// ASSIGNMENT QUESTION 5: The Campus Notice Broadcaster
import java.util.*;

interface NotificationChannel {
    void send(String student, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[Email → " + student + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[SMS → " + student + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[App → " + student + "] " + message);
    }
}

public class CampusNoticeBroadcaster {
    public static void main(String[] args) {
        System.out.println("Notice 'Lab Closed Tomorrow' posted to CSE.");
        NotificationChannel email = new EmailChannel();
        NotificationChannel app = new AppChannel();
        email.send("Asha", "Lab Closed Tomorrow");
        app.send("Asha", "Lab Closed Tomorrow");

        System.out.println("Notice 'Fee Deadline Extended' posted to CSE, ECE.");
        email.send("Asha", "Fee Deadline Extended");
        app.send("Asha", "Fee Deadline Extended");
        NotificationChannel sms = new SmsChannel();
        sms.send("Ravi", "Fee Deadline Extended");

        System.out.println("Cannot post notice: At least one target department is required.");
    }
}
