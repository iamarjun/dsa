package binary_search;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] a = {
                { 3, 4, 7, 9 },
                { 12, 13, 16, 18 },
                { 20, 21, 22, 29 },
                { 32, 35, 39, 40 },
                { 45, 47, 67, 89 },
        };

        int j = search(a, 39);
        System.out.println(j);
        j = searchOptimal(a, 39);
        System.out.println(j);
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

    private static int searchOptimal(int[][] a, int k) {
        int l = 0;
        int n = a.length;
        int m = a[0].length;
        int h = (n * m) - 1;

        while (l <= h) {
            int mid = (l + h) >> 1;
            int e = a[mid / n][mid % m];
            if (e == k) {
                return mid;
            } else if (e > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
