Let's take it up a notch. To build Pyramids and Diamonds, we have to manage two things at once: **Leading Spaces** and **Stars**.

Without the leading spaces, everything just stays left-aligned. To get that "mountain" look, we need to push the stars to the center.

---

### 1. The Pyramid Pattern

In a pyramid, the number of spaces decreases as you go down, while the number of stars (usually odd numbers ) increases.

```java
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

```

**The Math:** * **Spaces:** `rows - i`. On row 1, you need 4 spaces; on row 5, you need 0.

* **Stars:** `2 * i - 1`. This formula ensures an odd number of stars ().

---

### 2. The Diamond Pattern

A diamond is essentially a **Pyramid** followed by an **Inverted Pyramid**. We just need to be careful not to repeat the middle (widest) row twice.

```java
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

```

---

### Code Breakdown

* **The "Space" Loop:** Notice that `j` runs from `1` to `n - i`. As `i` grows, the number of spaces shrinks.
* **The "Star" Loop:** We use `2 * i - 1` to create the centered effect. If we just used `i`, it would look like a slanted triangle.
* **The Symmetry:** In the Diamond code, the second outer loop starts at `n - 1`. If we started at `n`, the middle row (the widest part) would print twice, making the diamond look "fat" in the center.

### Summary Table

| Pattern | Space Logic | Star Logic |
| --- | --- | --- |
| **Pyramid** | Decreasing (`n - i`) | Increasing Odd (`2i - 1`) |
| **Inverted Pyramid** | Increasing (`n - i`) | Decreasing Odd (`2i - 1`) |
| **Diamond** | Both of the above combined | Both of the above combined |

Would you like to try making a **Hollow Diamond** where only the border is made of stars?