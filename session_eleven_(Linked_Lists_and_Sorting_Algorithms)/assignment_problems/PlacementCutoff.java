// ASSIGNMENT PROBLEM 4: The Placement Cutoff (Quickselect for k-th highest)
public class PlacementCutoff {
    public static int kthHighest(int[] marks, int k) {
        int targetIndex = marks.length - k;
        return quickSelect(marks, 0, marks.length - 1, targetIndex);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == k) {
                return arr[k];
            } else if (pivotIndex < k) {
                return quickSelect(arr, pivotIndex + 1, high, k);
            } else {
                return quickSelect(arr, low, pivotIndex - 1, k);
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};
        System.out.println("2nd highest: " + kthHighest(marks, 2)); // Expected: 88
    }
}
