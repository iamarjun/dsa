package binary_search;

import java.util.Arrays;

public class PaintersPartition_SplitArrayLargestSum {
    public static void main(String[] args) {
        int a[] = { 10, 20, 30, 40 };
        int b = solve(a, 3);
        System.out.println(b);
    }

    public static int solve(int[] a, int k) {
        int l = a[0];
        int h = Arrays.stream(a).sum();

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (calc(a, m) > k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return l;
    }

    private static int calc(int[] a, int m) {
        int p = 1;
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] <= m) {
                sum += a[i];
            } else {
                p++;
                sum = a[i];
            }
        }

        return p;
    }

}
