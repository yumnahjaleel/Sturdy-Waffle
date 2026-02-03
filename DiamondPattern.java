public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5; // Distance from center to top/bottom
        StringBuilder sb = new StringBuilder();

        // PART 1: Upper Pyramid
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) sb.append(" ");
            for (int k = 1; k <= (2 * i - 1); k++) sb.append("*");
            sb.append("\n");
        }

        // PART 2: Lower Inverted Pyramid
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) sb.append(" ");
            for (int k = 1; k <= (2 * i - 1); k++) sb.append("*");
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
