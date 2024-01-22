package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        // int a[] = {2, 0, 0, 3};
        // var b = longestSubArrayBrute(a, 9);
        // var b = longestSubArrayBetter(a, 3);
        var b = longestSubArrayOptimal(a, 9);
        System.out.println(b);
    }

    private static int longestSubArrayBrute(int[] a, int k) {
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    private static int longestSubArrayBetter(int a[], int k) {
        int len = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == k) {
                len = Math.max(len, i + 1);
            }

            if (sum > k) {
                int x = sum - k;
                if (hash.containsKey(x)) {
                    len = Math.max(len, i - hash.get(x));
                }
            }

            if (!hash.containsKey(sum)) {
                hash.put(sum, i);
            }
        }

        return len;
    }

    // TC - O(2n) inned while loop at most will run for n
    private static int longestSubArrayOptimal(int[] a, int k) {
        int len = 0;
        int i = 0, j = 0;

        int sum = 0;

        while (j < a.length) {
            sum += a[j];
            
            while (sum > k) {
                sum -= a[i++];
            }

            if (sum == k) {
                len = Math.max(len, j - i + 1);
            }

            j++;

        }

        return len;
    }
}
