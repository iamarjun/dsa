package binary_search;

public class PeakElement {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 3, 2, 1 };
        int b[] = { 1, 2, 3, 4, 5, 6, 7 };
        int c[] = { 7, 6, 5, 4, 3, 2, 1 };
        int d[] = { 1, 2, 3, 1, 2, 3, 1 };
        
        System.out.println(findPeak(a));
        System.out.println(findPeak(b));
        System.out.println(findPeak(c));
        System.out.println(findPeak(d));
    }

    private static int findPeak(int[] a) {
        int n = a.length;

        if (n == 1) {
            return 0;
        }

        if (a[0] > a[1]) {
            return 0;
        }

        if (a[n - 1] > a[n - 2]) {
            return n - 1;
        }

        int l = 1;
        int h = n - 2;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[m] > a[m - 1] && a[m] > a[m + 1]) {
                return m;
            } else if (a[m] < a[m + 1]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }
}
