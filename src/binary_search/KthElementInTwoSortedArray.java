package binary_search;

public class KthElementInTwoSortedArray {
    public static void main(String[] args) {
        int a[] = { 2, 3, 45 };
        int b[] = { 4, 6, 7 };
        int c = kThElement(a, b, 5);
        System.out.println(c);
    }

    private static int kThElement(int[] a, int[] b, int k) {
        int n1 = a.length;
        int n2 = b.length;

        if (n1 > n2) {
            return kThElement(b, a, k);
        }

        int l = Math.max(k - n2, 0);
        int h = Math.min(n1, k);

        int left = k;

        while (l <= h) {
            int m1 = (l + h) >> 1;
            int m2 = left - m1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (m1 < n1) {
                r1 = a[m1];
            }

            if (m2 < n2) {
                r2 = b[m2];
            }

            if (m1 - 1 >= 0) {
                l1 = a[m1 - 1];
            }

            if (m2 - 1 >= 0) {
                l2 = a[m2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                h = m1 - 1;
            } else {
                l = m1 + 1;
            }
        }

        return -1;
    }
}
