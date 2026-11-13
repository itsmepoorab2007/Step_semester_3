// PROBLEM 4: Library Member JavaBean & Security Answer Property
public class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    private boolean idSet = false;

    public LibraryMemberBean() {
        // public no-arg constructor
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (!idSet) {
            this.membershipId = id;
            this.idSet = true;
        }
        // subsequent calls silently ignored (write-once)
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = "hashed:" + answer; // write-only, one-way transformed, no getter
    }

    public static void main(String[] args) {
        LibraryMemberBean m = new LibraryMemberBean();
        m.setMembershipId("LIB-8841");
        m.setMembershipId("FAKE-0000"); // ignored
        System.out.println("Membership ID: " + m.getMembershipId());
    }
}
