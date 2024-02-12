package binary_search;

public class HowManyTimesArrayHasBeenRotated {
    public static void main(String[] args) {
        int a[] = { 2, 3, 4, 5, 6, 1};
        int b = rotated(a);
        System.out.println(b);
    }

    private static int rotated(int[] a) {
        int l = 0;
        int h = a.length - 1;

        if (a[l] < a[h]) {
            return l;
        }

        while (l < h) {
            int m = l + (h - l) / 2;

            if (a[l] < a[h]) {
                return l;
            }

            if (a[m] > a[h]) {
                l = m + 1;
            } else if (a[m] < a[h]) {
                h = m;
            } else {
                h--;
            }
        }

        return l;
    }
}
