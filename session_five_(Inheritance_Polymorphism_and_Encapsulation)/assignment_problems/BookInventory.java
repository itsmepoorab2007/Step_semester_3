// PROBLEM 3: Book Copy Circulation Guard
public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
        // Silently rejected if no copies available
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
        // Silently rejected if already at full capacity
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public static void main(String[] args) {
        BookInventory b = new BookInventory(3);
        b.checkOut(); b.checkOut(); b.checkOut();
        b.checkOut(); // 4th attempt, rejected silently
        System.out.println("Available after excess checkouts: " + b.getCopiesAvailable());
    }
}
