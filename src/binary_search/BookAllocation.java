package binary_search;

import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int a[] = { 25, 46, 28, 49, 24 };
        int b = bookAllocation(a, 4);
        System.out.println(b);
        b = bookAllocationBs(a, 4);
        System.out.println(b);
    }

    private static int bookAllocation(int[] a, int s) {
        if (s > a.length) {
            return -1;
        }

        int l = Arrays.stream(a).max().getAsInt();
        int h = Arrays.stream(a).sum();

        for (int i = l; i < h; i++) {
            if (canTakeBooks(a, i) == s) {
                return i;
            }
        }

        return -1;
    }

    private static int bookAllocationBs(int[] a, int s) {
        if (s > a.length) {
            return -1;
        }

        int l = Arrays.stream(a).max().getAsInt();
        int h = Arrays.stream(a).sum();

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (canTakeBooks(a, m) > s) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return l;
    }

    private static int canTakeBooks(int[] a, int pages) {
        int student = 1;
        int studentPages = 0;

        for (int j = 0; j < a.length; j++) {
            if (studentPages + a[j] <= pages) {
                studentPages += a[j];
            } else {
                student++;
                studentPages = a[j];
            }
        }
        return student;
    }
}
