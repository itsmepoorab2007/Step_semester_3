// SECTION 5: Read-Only and Write-Only Properties
public class SrmStudentProfileProp {
    private final String regNo; // read-only property (set once in constructor, getter only)
    private String name;

    public SrmStudentProfileProp(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public String getRegNo() { return regNo; } // getter only, read-only
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

class PortalAccount {
    private String username;
    private String passwordHash; // write-only property (setter only, no getter)

    public void setPassword(String plainPassword) {
        this.passwordHash = hash(plainPassword); // stored, but deliberately no getPassword()
    }

    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }

    private String hash(String input) { return "hashed:" + input; }
}
