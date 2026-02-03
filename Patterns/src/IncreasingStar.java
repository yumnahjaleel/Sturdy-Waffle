import java.util.Scanner;

public class IncreasingStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Use StringBuilder to buffer the output
        StringBuilder pattern = new StringBuilder();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                pattern.append("* ");
            }
            // Add a newline character after each row
            pattern.append("\n");
        }

        // Single I/O operation to print the entire pattern
        System.out.print(pattern.toString());

        scanner.close();
    }
}
