package binary_search;

public class LowerBoundUpperBound {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
        int b = lowerBound(a, 5);
        System.out.println("lower bound " + b);
        int c = upperBound(a, 5);
        System.out.println("upper bound " + c);
        int d = floor(a, 6);
        System.out.println("floor " + d);
    }

    // smallest index i such that a[i] >= k
    private static int lowerBound(int[] a, int k) {
        int l = 0;
        int h = a.length - 1;

        int ans = a.length;

        while (l <= h) {

            int m = l + (h - l) / 2;

            if (a[m] >= k) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    // smallest index i such that a[i] > k
    private static int upperBound(int[] a, int k) {
        int l = 0;
        int h = a.length - 1;

        int ans = a.length;

        while (l <= h) {

            int m = l + (h - l) / 2;

            if (a[m] > k) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }

    // largest number which is <= k
    private static int floor(int[] a, int k) {
        int l = 0;
        int h = a.length - 1;

        int ans = a.length;

        while (l <= h) {

            int m = l + (h - l) / 2;

            if (a[m] > k) {
                h = m - 1;
            } else {
                ans = a[m];
                l = m + 1;
            }
        }

        return ans;
    }
}
