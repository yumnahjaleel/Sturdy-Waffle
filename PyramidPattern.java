public class PyramidPattern {
    public static void main(String[] args) {
        int rows = 5; // You can use Scanner here as well
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= rows; i++) {
            // 1. Append leading spaces
            for (int j = 1; j <= rows - i; j++) {
                sb.append(" ");
            }
            // 2. Append stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
