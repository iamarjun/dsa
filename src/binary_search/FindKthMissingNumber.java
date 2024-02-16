package binary_search;

public class FindKthMissingNumber {
    public static void main(String[] args) {

        int a[] = { 2, 3, 4, 7, 11 };
        int b = findMissing(a, 6);
        System.out.println(b);
        int c[] = { 6, 7, 15 };
        b = findMissing(c, 5);
        System.out.println(b);
    }

    private static int findMissing(int[] a, int k) {
        int l = 0;
        int n = a.length;
        int h = n - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            int missing = a[m] - (m + 1);

            if (missing < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return l + k;
    }
}
