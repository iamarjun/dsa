package arrays;

public class CountInversions {
    public static void main(String[] args) {
        int[] array = { 5, 3, 2, 1, 4 };
        int c = mergeSort(array, 0, array.length - 1);
        System.out.println(c);
    }

    private static int mergeSort(int[] a, int l, int r) {
        int count = 0;

        if (l >= r) {
            return count;
        }

        int m = l + (r - l) / 2;

        count += mergeSort(a, l, m);
        count += mergeSort(a, m + 1, r);
        count += merge(a, l, m, r);

        return count;
    }

    private static int merge(int[] a, int l, int m, int r) {
        int left = l;
        int right = m + 1;

        int count = 0;

        while (left <= m && right <= r) {
            if (a[left] < a[right]) {
                count++;
                left++;
            } else {
                right++;
            }
        }

        while (left <= m) {
            count++;
            left++;
        }

        return count;
    }

}
