package binary_search;

public class NthRootofAnInteger {
    public static void main(String[] args) {
        int a = nthRoot(82);
        System.out.println(a);
    }

    private static int nthRoot(int k) {
        int l = 0;
        int h = k;

        while (l <= h) {
            int m = l + (h - l) / 2;
            
            double j = Math.pow(m, 4);
            
            if (j == k) {
                return m;
            }

            if (j > k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
