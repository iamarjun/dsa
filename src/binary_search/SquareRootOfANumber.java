package binary_search;

public class SquareRootOfANumber {
    public static void main(String... args) {
        int a = findSqrt(5);
        System.out.println(a);
    }

    private static int findSqrt(int k) {
        int l = 0;
        int h = k;

        while(l <= h) {
            int m = l + (h-l)/2;
            if (m * m <= k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return h;
    }
}
