package arrays;

import java.util.Arrays;

public class LeftRotateAnArrayByNPlace {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        // rotateByNBrute(a, 5);
        rotateByNOptimal(a, 3);
        System.out.println(Arrays.toString(a));
    }

    // n = 1
    private static void rotate(int[] a) {

        var temp = a[0];

        for (int i = 1; i < a.length; i++) {
            a[i - 1] = a[i];
        }

        a[a.length - 1] = temp;
    }

    // rotate by d times
    // [1, 2, 3, 4, 5, 6, 7]
    private static void rotateByNBrute(int[] a, int d) {
        int n = a.length;
        d = d % n;

        int temp[] = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        // shift
        for (int i = d; i < n; i++) {
            a[i - d] = a[i];
        }

        // put back temp
        for (int i = n - d; i < n; i++) {
            a[i] = temp[i - (n - d)];
        }
    }

    private static void rotateByNOptimal(int[] a, int d) {
        reverse(a, 0, d - 1);
        reverse(a, d, a.length - 1);
        reverse(a, 0, a.length - 1);
    }

    private static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }


}
