// PROBLEM 4: Hot Weather Alert Windows (Sliding Window)
import java.util.List;

public class HotWeatherAlertWindows {
    public static int countAlerts(List<Integer> readings, int k, int threshold) {
        if (readings == null || readings.size() < k) return 0;

        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += readings.get(i);
        }

        int alertCount = 0;
        long targetSum = (long) k * threshold;

        if (currentSum >= targetSum) {
            alertCount++;
        }

        for (int i = k; i < readings.size(); i++) {
            currentSum += readings.get(i) - readings.get(i - k);
            if (currentSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        System.out.println("Hot Weather Alert Windows loaded successfully.");
    }
}
