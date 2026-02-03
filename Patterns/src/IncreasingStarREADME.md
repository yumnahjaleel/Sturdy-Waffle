When it comes to printing a pattern to the console, the bottleneck isn't actually the logic—it's the I/O (Input/Output) operations.
In the previous example, we called System.out.print inside the inner loop. 
Every time that command runs, the program has to communicate with the operating system to render a character on the screen.
Doing this hundreds or thousands of times is "expensive" in terms of performance.
The Solution: StringBuilderTo optimize this, we can use a StringBuilder. 
Instead of printing star by star, we build the entire pattern as one large string in memory and print it once at the very end.
While the mathematical complexity remains O(n^2) (because you still have to "touch" every star once),
the execution time is significantly faster for large inputs.

Method,Complexity,How it handles I/O: 
Nested Loops with print(),O(n2),"Frequent, slow interrupts to the OS for every star."
StringBuilder Buffer,O(n2),Fast memory operations; only one interrupt to the OS.
In Java, `append()` is a method belonging to the `StringBuilder` (and `StringBuffer`) class. 
Think of it like a **conveyor belt** adding items to a box. Instead of creating a brand-new box every time you add a star (which is what happens with regular `String` concatenation using `+`), `append()` just tosses the new star into the existing box.

---

### Why we use `append()` instead of `+`

Strings in Java are **immutable**, meaning they cannot be changed once created.

* **The `+` approach:** If you do `str = str + "*"`, Java actually creates a whole new string, copies the old one, and adds the star. In a loop of 1,000 stars, this creates 1,000 temporary objects.
* **The `append()` approach:** It uses a mutable "buffer" (an internal array). It just adds the characters to the end of that array without creating new objects.

---

### Code Breakdown: Line-by-Line

Let’s dissect the optimized version:

```java
// 1. Initialize the buffer
StringBuilder pattern = new StringBuilder(); 

```

* **What happens:** This creates an empty workspace in memory. It's currently size 0, waiting for data.

```java
// 2. The Outer Loop (Rows)
for (int i = 1; i <= rows; i++) { 

```

* **What happens:** This controls how many "lines" we are going to build. If `rows` is 5, this block runs 5 times.

```java
// 3. The Inner Loop (Stars)
for (int j = 1; j <= i; j++) {
    pattern.append("* ");
}

```

* **What happens:** * On row 1 (`i=1`), it appends `"* "` once.
* On row 2 (`i=2`), it appends `"* "` twice.
* **Crucially:** `append()` doesn't print anything to your screen yet; it just stores these characters in the `StringBuilder` object.



```java
// 4. The Line Break
pattern.append("\n");

```

* **What happens:** After the inner loop finishes a row, we append a **Newline Character** (`\n`). This ensures that the next set of stars starts on a fresh line in the buffer.

```java
// 5. The Grand Finale
System.out.print(pattern.toString());

```

* **What happens:** `pattern.toString()` converts that giant internal buffer into one single, massive String. `System.out.print` then pushes that entire String to your console in **one single move**.

---

### Summary of the Flow

| Step | Action | State of `StringBuilder` (if rows=3) |
| --- | --- | --- |
| **Row 1** | Append `* ` + `\n` | `"* \n"` |
| **Row 2** | Append `* * ` + `\n` | `"* \n* * \n"` |
| **Row 3** | Append `* * * ` + `\n` | `"* \n* * \n* * * \n"` |
| **End** | Print everything | (The full triangle appears instantly) |


