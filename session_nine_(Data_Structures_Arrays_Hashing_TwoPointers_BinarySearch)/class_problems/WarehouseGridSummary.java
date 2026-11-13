// PROBLEM 2: Warehouse Grid Summary (2D Array Processing)
public class WarehouseGridSummary {
    public static class Result {
        public int totalItems;
        public int[] maxCoordinate;
        public Result(int totalItems, int[] maxCoordinate) {
            this.totalItems = totalItems;
            this.maxCoordinate = maxCoordinate;
        }
    }

    public static Result warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                totalItems += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new Result(totalItems, new int[]{maxRow, maxCol});
    }

    public static void main(String[] args) {
        System.out.println("Warehouse Grid Summary loaded successfully.");
    }
}
