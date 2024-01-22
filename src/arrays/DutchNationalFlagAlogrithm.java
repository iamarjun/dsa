package arrays;

import java.util.Arrays;

public class DutchNationalFlagAlogrithm {
    public static void main(String[] args) {
        int[] a = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0 };
        dnf(a);
        System.out.println(Arrays.toString(a));
    }

    private static void dnf(int[] a) {
        int low = 0, mid = 0, high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low++, mid++);
                continue;
            }

            if (a[mid] == 1) {
                mid++;
                continue;
            }

            if (a[mid] == 2) {
                swap(a, mid, high--);
                continue;
            }
            
        }
    }

    private static void swap(int[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
