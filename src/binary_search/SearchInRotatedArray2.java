package binary_search;

public class SearchInRotatedArray2 {
    public static void main(String[] args) {
        int a[] = { 3, 3, 1, 2, 3, 3, 3, 3, 3, 3 };
        int c[] = { 21, 26, 30, 30, 32, 33, 35, 36, 40, 43, 47, 49, 4, 5, 19 };
        boolean b = search(c, 50);
        System.out.println(b);
    }

    private static boolean search(int a[], int k) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[m] == k) {
                return true;
            }

            if (a[l] == a[m] && a[m] == a[h]) {
                l++;
                h--;
                continue;
            }

            if (a[l] <= a[m]) {
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

        return false;
    }
}
