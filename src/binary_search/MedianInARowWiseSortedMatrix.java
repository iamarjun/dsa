package binary_search;

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 5, 7, 9, 11 },
                { 2, 3, 4, 5, 10 },
                { 9, 10, 12, 14, 16 },
        };

        int m = findMedian(a);
        System.out.println(m);
    }

    private static int findMedian(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int k = (n * m) / 2;

        int l = -1;
        for (int i = 0; i < n; i++) {
            l = Math.max(l, a[i][0]);
        }

        int h = -1;
        for (int i = 0; i < n; i++) {
            h = Math.max(h, a[i][m - 1]);
        }

        while (l <= h) {
            int mid = (l + h) >> 1;

            int e = noOfElementsGreater(a, mid);

            if (e > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static int noOfElementsGreater(int[][] a, int mid) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            int index = upperBound(a[i], mid);
            count += index;
        }

        return count;
    }

    private static int upperBound(int[] a, int k) {
        int l = 0;
        int h = a.length;

        while (l <= h) {
            int m = (l + h) >> 1;

            if (a[m] > k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
