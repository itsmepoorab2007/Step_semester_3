// SECTION 4: The JavaBean Standard (Getters and Setters)
public class SrmStudent {
    private String name;
    private int attendance;
    private boolean scholarshipHolder;

    public SrmStudent() { } // public no-arg constructor

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public int getAttendance() { 
        return attendance; 
    }
    public void setAttendance(int attendance) { 
        this.attendance = attendance; 
    }

    public boolean isScholarshipHolder() { 
        return scholarshipHolder; // boolean uses 'is', not 'get'
    }
    public void setScholarshipHolder(boolean scholarshipHolder) { 
        this.scholarshipHolder = scholarshipHolder; 
    }
}
