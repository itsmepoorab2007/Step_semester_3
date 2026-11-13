// PROBLEM 3: Most Popular Canteen Order (Hashing & Frequency Counting)
import java.util.*;

public class MostPopularCanteenOrder {
    public static class Result {
        public String item;
        public int count;
        public Result(String item, int count) {
            this.item = item;
            this.count = count;
        }
    }

    public static Result mostPopular(List<String> orders) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String order : orders) {
            freqMap.put(order, freqMap.getOrDefault(order, 0) + 1);
        }

        String bestItem = "";
        int maxCount = -1;

        for (String order : orders) {
            int count = freqMap.get(order);
            if (count > maxCount) {
                maxCount = count;
                bestItem = order;
            }
        }

        return new Result(bestItem, maxCount);
    }

    public static void main(String[] args) {
        System.out.println("Most Popular Canteen Order loaded successfully.");
    }
}
