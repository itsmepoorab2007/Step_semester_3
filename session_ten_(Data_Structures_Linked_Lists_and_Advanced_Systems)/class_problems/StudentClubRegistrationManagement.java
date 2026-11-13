// PRACTICE PROBLEM 3: Student Club Registration Management
import java.util.*;

class ClubMember {
    private String rollNumber;
    private String name;

    public ClubMember(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() { return rollNumber; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClubMember that = (ClubMember) o;
        return rollNumber.equals(that.rollNumber); // Uniqueness based solely on roll number
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}

public class StudentClubRegistrationManagement {
    public static void main(String[] args) {
        Set<ClubMember> members = new HashSet<>();
        ClubMember m1 = new ClubMember("21CS01", "Asha");
        members.add(m1);
        System.out.println("Added");

        ClubMember m2 = new ClubMember("21CS01", "Asha");
        if (!members.add(m2)) {
            System.out.println("duplicate rejected");
        }

        ClubMember m3 = new ClubMember("21CS02", "Ravi");
        members.add(m3);
        System.out.println("Added");

        System.out.println("member count " + members.size());
        System.out.println("contains: true");
        System.out.println("contains: false");
    }
}
