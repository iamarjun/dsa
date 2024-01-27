package arrays;

import java.util.Arrays;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int a[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };

        int b[][] = rotateOptimal(a, 4);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    private static int[][] rotate(int[][] a, int n) {
        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[j][n - 1 - i] = a[i][j];
            }
        }

        return b;
    }

    private static int[][] rotateOptimal(int a[][], int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                var temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverse(a[i]);
        }

        return a;
    }

    private static void reverse(int[] a) {
        int i = 0, j = a.length - 1;

        while (i <= j) {
            var temp = a[i];
            a[i++] = a[j];
            a[j--] = temp;
        }
    }
}
