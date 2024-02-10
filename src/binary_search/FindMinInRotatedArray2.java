package binary_search;

public class FindMinInRotatedArray2 {
    public static void main(String[] args) {
        int[] a = { 3, 4, 5, 6, 2, 3, 3 };
        int[] a1 = { 1, 1, 1, 1, 1, 1, 0, 1 };
        int[] a2 = { 10, 1, 10, 10, 10 };
        int b = findMinL(a2);
        int b1 = findMinR(a2);
        System.out.println(b);
        System.out.println(b1);
    }

    private static int findMinL(int[] a) {
        int l = 0;
        int h = a.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[l] < a[h]) {
                ans = Math.min(ans, a[l]);
                break;
            }

            if (a[l] < a[m]) {
                ans = Math.min(ans, a[l]);
                h = m;
            } else if (a[l] > a[m]) {
                ans = Math.min(ans, a[m]);
                l = m;
            } else {
                l++;
            }
        }

        return ans;
    }

    private static int findMinR(int[] a) {
        int l = 0;
        int h = a.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[l] < a[h]) {
                ans = Math.min(ans, a[l]);
                break;
            }

            if (a[m] < a[h]) {
                ans = Math.min(ans, a[l]);
                l = m;
            } else if (a[m] > a[h]) {
                ans = Math.min(ans, a[m]);
                h = m;
            } else {
                h--;
            }
        }

        return ans;
    }
}
