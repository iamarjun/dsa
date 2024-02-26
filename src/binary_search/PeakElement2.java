package binary_search;

import java.util.Arrays;

public class PeakElement2 {
    public static void main(String[] args) {
        int a[][] = {
                { 4, 2, 5, 1, 4, 5 },
                { 2, 1, 3, 2, 3, 2 },
                { 1, 2, 6, 0, 1, 3 },
                { 3, 0, 2, 3, 7, 1 }
        };

        int[] b = findPeak(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] findPeak(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int l = 0;
        int h = m - 1;

        while (l <= h) {
            int mid = (l + h) >> 1;

            int max = Integer.MIN_VALUE;
            int row = -1;

            for (int i = 0; i < a.length; i++) {
                if (a[i][mid] > max) {
                    max = a[i][mid];
                    row = i;
                }
            }

            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;

            if (row - 1 >= 0) {
                left = a[row - 1][mid];
            }

            if (row + 1 < m) {
                right = a[row + 1][mid];
            }

            if (max > right && max > left) {
                return new int[] { row, mid };
            } else if (right > max) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}
