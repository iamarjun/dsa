package binary_search;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenTheThreshold {
    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 9 };
        int threshold = 7;
        int b = smallestDivisor(a, threshold);
        System.out.println(b);
    }

    private static int smallestDivisor(int a[], int threshold) {
        int l = 1;
        int h = Arrays.stream(a).max().getAsInt();

        while (l <= h) {
            int m = l + (h - l) / 2;
            
            if (compute(a, m) <= threshold) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int compute(int[] a, int m) {
        int b = 0;
        for (int i : a) {
            b += Math.ceil((double) i / (double) m);
        }
        System.out.println("m " + m);
        System.out.println(b);
        return b;
    }
}
