package recursion;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {

        int[] array = { 5, 3, 2, 1, 4 };
        int c = mergeSort(array, 0, array.length - 1);
        System.out.println(c);
    }

    private static int mergeSort(int[] array, int l, int h) {
        int count = 0;
        if (l >= h) {
            return count;
        }

        int m = (l + h) / 2;

        count += mergeSort(array, l, m);
        count += mergeSort(array, m + 1, h);
        count += merge(array, l, m, h);

        return count;
    }

    private static int merge(int[] array, int l, int m, int h) {
        int count = 0;
        int left = l;
        int right = m + 1;

        ArrayList<Integer> list = new ArrayList<>();

        while (left <= m && right <= h) {
            if (array[left] <= array[right]) {
                list.add(array[left]);
                left++;
            } else {
                count += (m - left) + 1;
                list.add(array[right]);
                right++;
            }
        }

        while (left <= m) {
            list.add(array[left]);
            left++;
        }

        while (right <= h) {
            list.add(array[right]);
            right++;
        }

        for (int index = l; index <= h; index++) {
            array[index] = list.get(index - l);
        }

        return count;

    }

}
