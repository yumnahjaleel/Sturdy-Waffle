import java.util.Scanner;

public class DecreasingStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        // Outer loop starts at 'rows' and counts down to 1
        for (int i = rows; i >= 1; i--) {

            // Inner loop prints stars based on the current value of 'i'
            for (int j = 1; j <= i; j++) {
                sb.append("* ");
            }

            // Move to the next line
            sb.append("\n");
        }

        // Print the final result in one go
        System.out.print(sb.toString());

        scanner.close();
    }
}
