package arrays;

import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int a[] = { 5, 4, 7, 1, 2, 6, 9, 9, 9, 9, 3, 8};
        var b = -1;

        b = secondLargestElementOptimal(a);
        System.out.println(b);

        b = secondLargestElementBetter(a);
        System.out.println(b);
        
        b = secondLargestElementBrute(a);
        System.out.println(b);
    }

    // Brute force O(n * nlogn)
    private static int secondLargestElementBrute(int[] a) {
        Arrays.sort(a);
        var l = a[a.length - 1];
        var sl = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > sl && a[i] != l) {
                sl = a[i];
            }
        }

        return sl;
    }

    // Better O(2n)
    private static int secondLargestElementBetter(int[] a) {
        var l = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > l) {
                l = a[i];
            }
        }

        var sl = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > sl && a[i] != l) {
                sl = a[i];
            }
        }

        return sl;
    }

    // Optimal O(n)
    private static int secondLargestElementOptimal(int[] a) {
        var l = Integer.MIN_VALUE;
        var sl = Integer.MIN_VALUE - 1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > l) {
                sl = l;
                l = a[i];
            } else if (a[i] < l && a[i] > sl) {
                sl = a[i];
            }
        }

        return sl;
    }
}
