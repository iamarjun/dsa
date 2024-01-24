package arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int a[] = { 5, 4, 3, 2, 1 };
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }

    private static void nextPermutation(int a[]) {
        // find break point, start from n - 2
        int breakPoint = -1;

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                breakPoint = i;
                break;
            }
        }

        // since there is no break point, hence reverse the whole array
        if (breakPoint == -1) {
            reverse(a, 0, a.length - 1);
            return;
        }

        // find the first element greater than breakpoint and swap
        for (int i = a.length - 1; i >= breakPoint; i--) {
            if (a[i] > a[breakPoint]) {
                swap(a, i, breakPoint);
                break;
            }
        }

        reverse(a, breakPoint + 1, a.length - 1);

    }

    private static void swap(int[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void reverse(int[] a, int i, int j) {
        while (i <= j) {
            var temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
