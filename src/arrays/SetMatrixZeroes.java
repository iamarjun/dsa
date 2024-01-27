package arrays;

import java.util.Arrays;

/**
 * SetMatrixZeroes
 */
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] a = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
        };
        // setMatrixZeroesBrute(a);
        // setMatrixZeroesBetter(a);
        setMatrixZeroesOptimal(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    /**
     * Brute
     */
    private static void setMatrixZeroesBrute(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    markRow(a, i);
                    markColumn(a, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    private static void markRow(int[][] a, int i) {
        for (int j = 0; j < a.length; j++) {
            if (a[i][j] != 0) {
                a[i][j] = -1;
            }
        }
    }

    private static void markColumn(int[][] a, int j) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][j] != 0) {
                a[i][j] = -1;
            }
        }
    }

    /**
     * Better
     */

    private static void setMatrixZeroesBetter(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == -1 || col[j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    private static void setMatrixZeroesOptimal(int[][] a) {
        int col0 = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;

                    if (j > 0) {
                        a[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
        }

        if (a[0][0] == 0) {
            for (int i = 0; i < a.length; i++) {
                a[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < a.length; i++) {
                a[i][0] = 0;
            }
        }

    }

}