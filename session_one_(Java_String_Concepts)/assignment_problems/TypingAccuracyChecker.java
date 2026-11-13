public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int totalChars = original.length();
        int matches = 0;
        int firstMismatchPos = -1;
        char mismatchOriginal = ' ';
        char mismatchTyped = ' ';

        for (int i = 0; i < totalChars; i++) {
            if (i < typed.length() && original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    mismatchOriginal = original.charAt(i);
                    mismatchTyped = i < typed.length() ? typed.charAt(i) : ' ';
                }
            }
        }

        double accuracy = ((double) matches / totalChars) * 100.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", matches, totalChars, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n",
                    matches, totalChars, accuracy, firstMismatchPos, mismatchOriginal, mismatchTyped);
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
