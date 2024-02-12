package binary_search;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6 };
        int b = findSingleElement(a);
        System.out.println(b);
    }

    private static int findSingleElement(int[] a) {
        int n = a.length;
        int l = 0;
        int h = n - 1;

        if (n == 1) {
            return a[0];
        }

        if (a[0] != a[1]) {
            return a[0];
        }

        if (a[n - 1] != a[n - 2]) {
            return a[n - 1];
        }

        l++;
        h--;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[m] != a[m - 1] && a[m] != a[m + 1]) {
                return a[m];
            }

            if (m % 2 == 0) {
                if (a[m] != a[m + 1]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (a[m] != a[m - 1]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;

    }
}
