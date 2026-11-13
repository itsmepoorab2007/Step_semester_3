// PROBLEM 5: Maximize Area Between Two Boundaries (Container With Most Water)
public class MaximizeAreaBetweenTwoBoundaries {
    public static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            int w = right - left;
            int area = h * w;
            if (area > maxArea) {
                maxArea = area;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Maximize Area Between Two Boundaries loaded successfully.");
    }
}
