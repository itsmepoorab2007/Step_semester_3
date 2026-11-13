// PROBLEM 5: Ticket Price Slot Finder (Binary Search for Insertion Index)
import java.util.List;

public class TicketPriceSlotFinder {
    public static int findSlot(List<Integer> prices, int newPrice) {
        int low = 0;
        int high = prices.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = prices.get(mid);

            if (val == newPrice) {
                return mid;
            } else if (val < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println("Ticket Price Slot Finder loaded successfully.");
    }
}
