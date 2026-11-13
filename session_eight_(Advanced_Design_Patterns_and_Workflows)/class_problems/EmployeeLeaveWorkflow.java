// QUESTION 2: Employee Leave Request Workflow
class LeaveRequest {
    private String employeeName;
    private int days;
    private String status; // Pending, Approved, Rejected

    public LeaveRequest(String employeeName, int days) {
        this.employeeName = employeeName;
        this.days = days;
        this.status = "Pending";
    }

    public String getStatus() { return status; }
    public String getEmployeeName() { return employeeName; }

    public void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
        }
    }

    public void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
        }
    }

    public void setStatus(String newStatus) {
        if (this.status.equals("Approved") && newStatus.equals("Pending")) {
            System.out.println("Cannot change leave request status from Approved to Pending.");
            return;
        }
        this.status = newStatus;
    }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        LeaveRequest reqJohn = new LeaveRequest("John", 5);
        System.out.println("Leave request submitted for John (Jan 1-5). Status: " + reqJohn.getStatus());
        
        reqJohn.approve();
        System.out.println("John's leave request (Jan 1-5) approved. Status: " + reqJohn.getStatus());

        LeaveRequest reqJane = new LeaveRequest("Jane", 2);
        System.out.println("Leave request submitted for Jane (Feb 10-11). Status: " + reqJane.getStatus());
        
        reqJane.reject();
        System.out.println("Jane's leave request (Feb 10-11) rejected. Status: " + reqJane.getStatus());

        reqJohn.setStatus("Pending");
    }
}
