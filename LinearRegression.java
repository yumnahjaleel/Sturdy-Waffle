import java.util.Scanner;

public class LinearRegression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Data Input (Example: X could be 'Hours Studied', Y could be 'Exam Score')
        System.out.print("Enter the number of data points: ");
        int n = scanner.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        double sumX = 0, sumY = 0;

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter point %d (x y): ", i + 1);
            x[i] = scanner.nextDouble();
            y[i] = scanner.nextDouble();
            sumX += x[i];
            sumY += y[i];
        }

        // 2. Calculate Means
        double meanX = sumX / n;
        double meanY = sumY / n;

        // 3. Calculate Slope (m) and Intercept (b)
        double numerator = 0;
        double denominator = 0;

        for (int i = 0; i < n; i++) {
            numerator += (x[i] - meanX) * (y[i] - meanY);
            denominator += Math.pow(x[i] - meanX, 2);
        }

        double slope = numerator / denominator;
        double intercept = meanY - (slope * meanX);

        // 4. Output the Model
        System.out.println("\n--- Regression Model ---");
        System.out.printf("Equation: y = %.4fx + %.4f%n", slope, intercept);

        // 5. Prediction Logic
        System.out.print("\nEnter an X value to predict Y: ");
        double inputX = scanner.nextDouble();
        double predictedY = (slope * inputX) + intercept;

        System.out.printf("Predicted Y value: %.4f%n", predictedY);

        scanner.close();
    }
}
