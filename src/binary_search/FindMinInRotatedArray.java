package binary_search;

public class FindMinInRotatedArray {
    public static void main(String[] args) {
        int[] a = { 3, 2, 1, 4, 5, 6 };
        int b = findMin(a);
        System.out.println(b);
    }

    private static int findMin(int[] a) {
        int l = 0;
        int h = a.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (a[l] < a[m]) {
                ans = Math.min(ans, a[l]);
                l = m + 1;
            } else {
                ans = Math.min(ans, a[m]);
                h = m - 1;
            }
        }

        return ans;
    }
}
