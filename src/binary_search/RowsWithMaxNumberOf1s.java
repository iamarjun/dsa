package binary_search;

public class RowsWithMaxNumberOf1s {
    public static void main(String[] args) {
        int[][] a = {
                { 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1 },
        };

        int m = findRowWithMax1s(a);
        System.out.println(m);
    }

    private static int findRowWithMax1s(int[][] a) {
        int row = -1;
        int maxCount = 0;
        for (int i = 0; i < a.length; i++) {
            int j = lowerBound(a[i], 1);
            int count = a[i].length - j;
            if (count > maxCount) {
                maxCount = count;
                row = i;
            }
        }

        return row;
    }

    private static int lowerBound(int a[], int k) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = (l + h) >> 1;

            if (a[m] >= k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

}
