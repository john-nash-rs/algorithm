public class FibonacciRecursion {

    public static void main(String[] args) {
        int n = 30; // You can change the value of 'n' to generate a different number of terms in the series
        System.out.println("Fibonacci Series up to " + n + " terms:");
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            System.out.println(fibonacci(i) + " ");
        }
        long endTime = System.nanoTime();
        System.out.println("Total time taken " + (endTime - startTime));
    }

    // Recursive method to calculate Fibonacci number at position 'n'
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
