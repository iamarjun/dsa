package binary_search;

import java.util.Arrays;

public class FirstAndLastOccuranceOfAGivenNumberInASortedArray {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 9 };
        int ans[] = firstAndLastOccurance(a, 6);
        System.out.println(Arrays.toString(ans));

    }

    private static int[] firstAndLastOccurance(int[] a, int k) {
        int first = lowerBound(a, k);
        if (a[first] == k) {
            return new int[] { first, upperBound(a, k) - 1 };
        }
        return new int[] { -1, -1 };
    }

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
}
