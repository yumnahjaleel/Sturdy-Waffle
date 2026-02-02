import java.util.Scanner;

public class StatisticsCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Get input from the user
        System.out.print("Enter the number of elements in your dataset: ");
        int n = input.nextInt();

        double[] data = new double[n];
        double sum = 0;

        System.out.println("Enter the " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            data[i] = input.nextDouble();
            sum += data[i];
        }

        // 2. Calculate the Mean (Average)
        double mean = sum / n;

        // 3. Calculate Variance
        // Formula: sum of (value - mean)^2 / n
        double squaredDiffSum = 0;
        for (int i = 0; i < n; i++) {
            squaredDiffSum += Math.pow(data[i] - mean, 2);
        }
        double variance = squaredDiffSum / n;

        // 4. Calculate Standard Deviation
        double standardDeviation = Math.sqrt(variance);

        // 5. Output Results
        System.out.println("\n--- Statistical Results ---");
        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Variance: %.2f%n", variance);
        System.out.printf("Standard Deviation: %.2f%n", standardDeviation);

        input.close();
    }
}
