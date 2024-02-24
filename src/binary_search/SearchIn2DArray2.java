package binary_search;

import java.util.Arrays;

public class SearchIn2DArray2 {
    public static void main(String[] args) {
        int[][] a = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
                { 32, 39, 44, 90 },
                { 45, 62, 71, 99 },
        };

        int j = search(a, 39);
        System.out.println(j);
        int[] k = searchOptimal(a, 39);
        System.out.println(Arrays.toString(k));
    }

    // O(n log m)
    private static int search(int[][] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] <= k && a[i][a[i].length - 1] >= k) {
                int j = Arrays.binarySearch(a[i], k);
                return j;
            }
        }

        return -1;
    }


    // log (n + m)
    private static int[] searchOptimal(int[][] a, int k) {

        int r = 0;
        int c = a[0].length - 1;

        while (r < a.length && c >= 0) {
            if (a[r][c] == k) {
                return new int[] { r, c };
            } else if (a[r][c] > k) {
                c--;
            } else {
                r++;
            }
        }

        return new int[] { -1, -1 };
    }
}
