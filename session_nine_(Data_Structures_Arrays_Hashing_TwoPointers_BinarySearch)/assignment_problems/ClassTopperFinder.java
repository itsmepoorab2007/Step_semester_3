// PROBLEM 1: Class Topper Finder (2D Array Row Totals)
public class ClassTopperFinder {
    public static int[] findTopper(int[][] marks) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < marks.length; r++) {
            int currentTotal = 0;
            for (int c = 0; c < marks[r].length; c++) {
                currentTotal += marks[r][c];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRow = r;
            }
        }
        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };
        int[] res = findTopper(marks);
        System.out.println("Topper Row: " + res[0] + ", Total: " + res[1]);
    }
}
