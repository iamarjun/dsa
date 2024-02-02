package arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithXorK {
    public static void main(String[] args) {
        int a[] = {4, 2, 2, 6, 4};
        int b = countSubarray(a, 6);
        System.out.println(b);
    }

    private static int countSubarray(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int xor = 0;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            xor = xor ^ a[i];

            int b = xor ^ k;

            count += map.getOrDefault(b, 0);
            map.put(xor, map.getOrDefault(b, 0) + 1);

        }

        System.out.println(map.toString());

        return count;
    }
}
