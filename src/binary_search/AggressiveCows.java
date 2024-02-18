package binary_search;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] a = { 0, 3, 4, 7, 9, 10 };
        int b = maxOfTheMinDistanceBetweenCows(a, 4);
        System.out.println(b);
        b = maxOfTheMinDistanceBetweenCowsBS(a, 3);
        System.out.println(b);
    }

    private static int maxOfTheMinDistanceBetweenCows(int a[], int cows) {
        Arrays.sort(a);
        int l = 1;
        int n = a.length;
        int h = a[n - 1];

        for (int i = l; i < h; i++) {
            if (possible(a, cows, i)) {
                continue;
            } else {
                return i - 1;
            }
        }

        return -1;
    }

    private static int maxOfTheMinDistanceBetweenCowsBS(int a[], int cows) {
        Arrays.sort(a);
        int l = 1;
        int n = a.length;
        int h = a[n - 1];

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (possible(a, cows, m)) {
                l = m + 1;
            } else {
                h = m - 1;
            }

        }

        return h;
    }

    private static boolean possible(int[] a, int cows, int i) {
        int cowsCount = 1;
        int lastCow = a[0];
        for (int j = 0; j < a.length; j++) {
            if (a[j] - lastCow >= i) {
                cowsCount++;
                lastCow = a[j];
            }
        }

        return cowsCount >= cows;
    }
}
