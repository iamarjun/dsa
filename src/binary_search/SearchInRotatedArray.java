package binary_search;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int a[] = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int b = search(a, 1);
        System.out.println(b);
    }

    private static int search(int a[], int k) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[m] == k) {
                return m;
            } else if (a[l] <= a[m]) {
                if (a[l] <= k && k <= a[m]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (a[m] <= a[h]) {
                if (a[m] <= k && k <= a[h]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return -1;
    }
}
