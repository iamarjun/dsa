package recursion;

public class QuickSort {
    public static void main(String[] args) {
        
    }

    private static void qs(int[] a, int l, int h) {
        if (l > h) {
            return;
        }
        int pivot = a[l];

        int i = l, j = h;

        while (i < j) {

            while (a[i] >= pivot && i <= h - 1) {
                i++;
            }

            while (a[j] < pivot && j >= l + 1) {
                j--;
            }

            if (i < j) {
                swap(j, a, i);
            }
        }

        swap(j, a, l);

        qs(a, l, j - 1);
        qs(a, j + 1, h);

    }

    private static void qsDes(int[] a, int l, int h) {
        if (l > h) {
            return;
        }
        int pivot = a[l];

        int i = l, j = h;

        while (i < j) {

            while (a[i] >= pivot && i <= h - 1) {
                i++;
            }

            while (a[j] < pivot && j >= l + 1) {
                j--;
            }

            if (i < j) {
                swap(j, a, i);
            }
        }

        swap(j, a, l);

        qs(a, l, j - 1);
        qs(a, j + 1, h);

    }

    private static void swap(int index, int[] a, int i) {
        int temp = a[i];
        a[i] = a[index];
        a[index] = temp;
    }

}
