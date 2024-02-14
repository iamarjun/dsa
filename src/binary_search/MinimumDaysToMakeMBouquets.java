package binary_search;

public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        int a[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2, k = 3;

        int b = findMinDaysToMakeBouquets(a, m, k);
        System.out.println(b);
        b = findMinDaysToMakeBouquetss(a, m, k);
        System.out.println(b);
    }

    private static int findMinDaysToMakeBouquets(int[] a, int m, int k) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        int n = a.length;

        if (n < m * k) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            l = Math.min(l, a[i]);
            h = Math.max(h, a[i]);
        }

        for (int i = l; i <= h; i++) {
            if (possibleToMakeBouquets(a, m, k, i)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean possibleToMakeBouquets(int[] a, int m, int k, int days) {
        int count = 0;
        int noOfB = 0;
        for (int j = 0; j < a.length; j++) {
            if (a[j] <= days) {
                count++;
                if (count > k) {
                    count = 0;
                }
            } else {
                noOfB += count / k;
                count = 0;
            }
        }
        noOfB += count / k;

        return noOfB >= m;
    }

    private static int findMinDaysToMakeBouquetss(int a[], int m, int k) {
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        int n = a.length;

        if (n < m * k) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            l = Math.min(l, a[i]);
            h = Math.max(h, a[i]);
        }

        while (l <= h) {
            int g = l + (h - l) / 2;

            if (possibleToMakeBouquets(a, m, k, g)) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
