package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        
    }

    // 2^n
    private static int fibonacci(int n) {
        if (n <= 0) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
