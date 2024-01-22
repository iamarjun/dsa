package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 6, 7, 10 };
        int b[] = { 2, 3, 5, 6, 9, 8 };
        int c[] = union(a, b);
        System.out.println(Arrays.toString(c));
    }

    private static int[] union(int[] a, int[] b) {
        int i = 0, j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        int lastTaken = -1;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (lastTaken != a[i]) {
                    lastTaken = a[i];
                    union.add(a[i]);
                }
                i++;
            } else {
                if (lastTaken != b[j]) {
                    lastTaken = b[j];
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i < a.length) {
            if (lastTaken != a[i]) {
                lastTaken = a[i];
                union.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (lastTaken != b[j]) {
                lastTaken = b[j];
                union.add(b[j]);
            }
            j++;
        }

        int[] c = new int[union.size()];

        for (int k = 0; k < union.size(); k++) {
            c[k] = union.get(k);
        }

        return c;
    }
}
