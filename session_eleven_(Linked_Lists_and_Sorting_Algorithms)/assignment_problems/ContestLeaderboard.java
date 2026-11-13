// ASSIGNMENT PROBLEM 5: The Contest Leaderboard (Counting Sort)
class ContestEntry {
    String name;
    int marks;

    public ContestEntry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}

public class ContestLeaderboard {
    public static ContestEntry[] leaderboard(ContestEntry[] entries) {
        int[] count = new int[101];
        for (ContestEntry e : entries) {
            count[e.marks]++;
        }

        // Cumulative count for stability from right to left
        // Wait, for descending order (highest to lowest):
        // Let's position marks from 100 down to 0.
        int[] startIdx = new int[101];
        int currentIdx = 0;
        for (int m = 100; m >= 0; m--) {
            startIdx[m] = currentIdx;
            currentIdx += count[m];
        }

        ContestEntry[] sorted = new ContestEntry[entries.length];
        // To maintain stability of submission order, iterate from right to left of input
        for (int i = entries.length - 1; i >= 0; i--) {
            ContestEntry e = entries[i];
            int pos = startIdx[e.marks];
            sorted[pos] = e;
            startIdx[e.marks]++;
        }

        return sorted;
    }

    public static void main(String[] args) {
        ContestEntry[] entries = {
            new ContestEntry("Asha", 90),
            new ContestEntry("Ravi", 75),
            new ContestEntry("Neha", 90),
            new ContestEntry("Kiran", 100),
            new ContestEntry("Meera", 75)
        };
        ContestEntry[] sorted = leaderboard(entries);
        for (ContestEntry e : sorted) {
            System.out.print(e + ", ");
        }
        System.out.println();
    }
}
