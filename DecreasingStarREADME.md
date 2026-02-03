To create an **inverted star pattern**, we simply flip the logic: we start the loop at the maximum number of stars and decrease the count until we reach one.

I'll provide the optimized version using `StringBuilder` and `append()`, as we discussed, since it's more efficient for your computer to handle.

---

### The Java Code

```java
import java.util.Scanner;

public class InvertedStarPattern {
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

```

---

### Logic Breakdown: The "Countdown" Method

The key difference here is in the **Outer Loop initialization**:

1. **Initialization (`int i = rows`):** We start `i` at the total number of rows (e.g., 5).
2. **Condition (`i >= 1`):** The loop keeps running as long as `i` is at least 1.
3. **Decrement (`i--`):** Instead of adding 1, we subtract 1 after every row.

**Example Trace (if rows = 3):**

* **Row 1:** `i` is 3. The inner loop runs 3 times. Output: `* * *`
* **Row 2:** `i` becomes 2. The inner loop runs 2 times. Output: `* *`
* **Row 3:** `i` becomes 1. The inner loop runs 1 time. Output: `*`

---

### Comparison: Normal vs. Inverted

| Feature | Normal Pattern | Inverted Pattern |
| --- | --- | --- |
| **Start Value** | `i = 1` | `i = rows` |
| **End Condition** | `i <= rows` | `i >= 1` |
| **Update** | `i++` (Increasing) | `i--` (Decreasing) |

Would you like to try combining these two to create a **Diamond pattern**?