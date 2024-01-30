package arrays;

import java.util.HashMap;

public class CountSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int b = countSubarray(a, 3);
        System.out.println(b);
    }

    private static int countSubarray(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        map.put(0, 1);


        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            int m = sum - k;

            count += map.getOrDefault(m, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }

        return count;
    }
}
