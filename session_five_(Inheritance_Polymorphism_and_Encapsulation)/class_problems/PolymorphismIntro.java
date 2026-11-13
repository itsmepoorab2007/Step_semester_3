// SECTION 5: What Is Polymorphism?
class GenericTicket {
    public void printTicket() {
        System.out.println("Standard Ticket");
    }
}

class PolyWorkshopTicket extends GenericTicket {
    private String track;
    public PolyWorkshopTicket(String track) { this.track = track; }

    @Override
    public void printTicket() {
        System.out.println("Workshop Ticket | Track: " + track);
    }
}

public class PolymorphismIntroDemo {
    public static void printAnyTicket(GenericTicket t) {
        t.printTicket(); // Polymorphic dispatch
    }

    public static void main(String[] args) {
        GenericTicket t = new PolyWorkshopTicket("AI/ML");
        printAnyTicket(t);
    }
}
