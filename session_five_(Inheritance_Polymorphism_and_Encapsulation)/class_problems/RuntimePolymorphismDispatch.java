// SECTION 7: Runtime Polymorphism, Dynamic Dispatch, Upcasting & Downcasting
class BaseTicket {
    public void showType() { System.out.println("Base Ticket"); }
}

class DerivedTicket extends BaseTicket {
    private String detail;
    public DerivedTicket(String detail) { this.detail = detail; }
    public String getDetail() { return detail; }

    @Override
    public void showType() { System.out.println("Derived Ticket: " + detail); }
}

public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        BaseTicket t = new DerivedTicket("AI Lab"); // Upcasting
        t.showType(); // Dynamic Method Dispatch

        if (t instanceof DerivedTicket) {
            DerivedTicket dt = (DerivedTicket) t; // Downcasting
            System.out.println("Downcast successful, detail: " + dt.getDetail());
        }
    }
}
