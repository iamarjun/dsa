package arrays;

import java.util.ArrayList;

public class ReversePairs {
    public static void main(String[] args) {

    }

    private static int countReversePairs(int a[]) {
        return divide(a, 0, a.length - 1);
    }

    private static int divide(int[] a, int l, int h) {
        int count = 0;

        if (l >= h) {
            return count;
        }

        int m = l + (h - l) / 2;

        count += divide(a, l, m);
        count += divide(a, m + 1, h);
        count += count(a, l, m, h);
        conquer(a, l, m, h);

        return count;
    }

    private static int count(int[] a, int l, int m, int h) {
        int left = l;
        int right = m + 1;

        int count = 0;

        for (int i = left; i < m; i++) {
            while (right <= h && a[i] > 2 * a[right]) {
                right++;
            }
            count += right - (m + 1);
        }

        return count;
    }

    private static void conquer(int[] a, int l, int m, int h) {
        var left = l;
        var right = m + 1;
        var temp = new ArrayList<Integer>();
        while (left <= m && right <= h) {
            if (a[left] <= a[right]) {
                temp.add(a[left++]);
            } else {
                temp.add(a[right++]);
            }
        }

        while (left <= m) {
            temp.add(a[left++]);
        }

        while (right <= h) {
            temp.add(a[right++]);
        }

        for (int i = l; i <= h; i++) {
            a[i] = temp.get(i - l);
        }
    }
}
