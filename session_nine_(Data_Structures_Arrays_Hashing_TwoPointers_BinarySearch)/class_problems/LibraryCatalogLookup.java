// PROBLEM 1: Library Catalog Lookup (Binary Search on sorted list)
import java.util.List;

public class LibraryCatalogLookup {
    public static String findBook(List<String[]> catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String[] record = catalog.get(mid);
            String isbn = record[0];
            String title = record[1];

            int cmp = isbn.compareTo(targetIsbn);
            if (cmp == 0) {
                return title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        System.out.println("Library Catalog Lookup loaded successfully.");
    }
}
