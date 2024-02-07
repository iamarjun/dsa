package arrays;

public class MaximumProdcutSubarray {
    public static void main(String[] args) {

    }

    private static int maximumProdcutSubarray(int[] a) {
        int prefixSum = 1;
        int suffixSum = 1;
        int ans = Integer.MIN_VALUE;
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            if (prefixSum == 0) {
                prefixSum = 1;
            }

            if (suffixSum == 0) {
                suffixSum = 1;
            }

            prefixSum *= a[i];
            suffixSum *= a[n - 1 - i];

            ans = Math.max(ans, Math.max(prefixSum, suffixSum));
        }

        return ans;
    }
}
