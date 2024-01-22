package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] array = {5, 3, 6, 2, 1, 4};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

     private static void mergeSort(int[] a, int l, int h) {
        if (l >= h) {
            return;
        }
        var m = l + (h - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, h);
        merge(a, l, m, h);
    }

    private static void merge(int[] a, int l, int m, int h) {
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
            System.out.print(i + " ");
            System.out.print(temp.get(i - l) + " ");
            System.out.println();
        }
        System.out.println();
    }

}
