package arrays;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int a[] = { 1, 3, 5, 7, 9 };
        int b[] = { 2, 4, 6, 8, 10 };
        mergeOptimal2(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    // tc - O(n + m) sc - O(n + m)
    private static void mergeBrute(int[] a, int b[]) {
        int n = a.length;
        int m = b.length;

        int[] c = new int[n + m];

        int i = 0, j = 0;
        int index = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                c[index++] = a[i++];
            } else {
                c[index++] = b[j++];
            }
        }

        while (i < n) {
            c[index++] = a[i++];
        }

        while (j < m) {
            c[index++] = b[j++];
        }

        for (int k = 0; k < n; k++) {
            a[k] = c[k];
        }

        for (int k = n; k < c.length; k++) {
            b[k - m] = c[k];
        }
    }

    private static void mergeOptimal1(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            if (a[i] > b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);

    }

    private static void mergeOptimal2(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int l = n + m;

        int gap = (l / 2) + (l % 2);

        while (gap > 0) {
            int i = 0;
            int j = i + gap;
            while (j < l) {
                // in first and second array
                if (i < n && j >= n) {
                    swap(a, b, i, j - n);
                }
                // in second array
                else if (i >= n) {
                    swap(b, b, i - n, j - n);
                }
                // in first array
                else {
                    swap(a, a, i, j);
                }
                i++;
                j++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    private static void swap(int[] a, int[] b, int i, int j) {
        if (a[i] < b[j]) {
            return;
        }
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
