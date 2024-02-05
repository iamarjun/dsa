package arrays;

import java.util.Arrays;

public class FindMissingAndRepeatingNumbers {
    public static void main(String[] args) {
        int[] a = { 4, 3, 6, 2, 1, 1 };
        // int[] b = findMissingAndRepeatingNumber1(a);
        // int[] b = findMissingAndRepeatingNumber2(a);
        int[] b = findMissingAndRepeatingNumber3(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] findMissingAndRepeatingNumber1(int[] a) {
        int missing = -1, repeating = -1;

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (i + 1 == a[j]) {
                    count++;
                }
            }
            if (count == 0) {
                missing = i + 1;
            }
            if (count > 1) {
                repeating = i + 1;
            }
        }

        return new int[] { missing, repeating };
    }

    private static int[] findMissingAndRepeatingNumber2(int[] a) {
        int missing = -1, repeating = -1;
        int[] hash = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            hash[a[i] - 1]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 1) {
                repeating = i + 1;
            }

            if (hash[i] == 0) {
                missing = i + 1;
            }
        }

        return new int[] { missing, repeating };
    }

    private static int[] findMissingAndRepeatingNumber3(int[] a) {
        int n = a.length;

        int sn = (n * (n + 1)) / 2;
        int s2n = (n * (n + 1) * (2 * n + 1)) / 6;

        int s = 0, s2 = 0;

        for (int i = 0; i < a.length; i++) {
            s += a[i];
            s2 += a[i] * a[i];
        }

        int v1 = s - sn;
        int v2 = s2 - s2n;

        v2 = v2 / v1;

        int x = (v1 + v2) / 2;
        int y = x - v1;

        return new int[] { x, y };
    }
}
