/**
 * n = 25 4880583
 * n = 30 313000
 */
public class FibonacciRecursionWithDP {

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

    // Dynamic programming method to calculate Fibonacci number at position 'n'
    public static int fibonacci(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}
