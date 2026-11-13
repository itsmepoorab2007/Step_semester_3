public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        else if (bmi >= 25 && bmi <= 29.9) return "Overweight";
        else return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s %-15s %-15s %-10s %-15s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("%-10s %-15.2f %-15.2f %-10.2f %-15s\n", 
                ("Person " + (i + 1)), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.72, 1.55, 1.90, 1.68, 1.75};
        double[] weights = {70.0, 90.0, 75.0, 50.0, 82.0, 68.0, 45.0, 105.0, 60.0, 80.0};

        printWellnessReport(heights, weights);
    }
}
