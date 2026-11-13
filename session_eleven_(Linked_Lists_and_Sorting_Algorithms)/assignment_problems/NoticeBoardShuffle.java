// ASSIGNMENT PROBLEM 1: The Notice Board Shuffle (Bubble Sort with stats)
public class NoticeBoardShuffle {
    public static int[] bubbleStats(int[] scores) {
        int passes = 0;
        int swaps = 0;
        boolean swapped = true;
        int n = scores.length;

        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;
            passes++;
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
        }
        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] scores = {5, 1, 4, 2, 8};
        int[] stats = bubbleStats(scores);
        System.out.println("Passes: " + stats[0] + ", Swaps: " + stats[1]);
    }
}
