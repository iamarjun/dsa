package binary_search;

public class KokoEatingBanana {
    public static void main(String[] args) {
        int[] a = { 3, 6, 7, 11 };
        int h = minHoursToEatBanana(a, 8);
        System.out.println(h);
    }

    private static int minHoursToEatBanana(int[] a, int h) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            l = Math.min(l, a[i]);
            r = Math.max(r, a[i]);
        }

        while (l <= r) {
            int m = l + (r - l) / 2;
            int reqHours = calculateRequiresHours(a, m);

            if (reqHours <= h) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int calculateRequiresHours(int[] a, int m) {
        int ans = 0;
        for (int i : a) {
            ans += Math.ceil((double) i / (double) m);
        }
        return ans;
    }
}
