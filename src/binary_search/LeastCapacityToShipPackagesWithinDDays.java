package binary_search;

import java.util.Arrays;

public class LeastCapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        int b = leastCapacity(a, days);
        System.out.println(b);
    }

    private static int leastCapacity(int a[], int days) {
        int l = Arrays.stream(a).max().getAsInt();
        int h = Arrays.stream(a).sum();

        while (l <= h) {
            int m = l + (h - l) / 2;

            int b = daysToShipWithCapacity(a, m);

            if (b <= days) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int daysToShipWithCapacity(int[] a, int m) {
        int b = a[0];
        int days = 0;
        for (int i = 1; i < a.length; i++) {
            b += a[i];
            if (b > m) {
                days++;
                b = a[i];
            }
        }
        if (b <= m) {
            days++;
        }
        System.out.println("Capacity " + m + " days " + days);
        return days;
    }
}
