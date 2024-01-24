package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LeadersInAnArray {
    public static void main(String[] args) {
        int a[] = { 10, 22, 12, 3, 0, 6 };
        int b[] = leaders(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] leaders(int a[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > max) {
                max = a[i];
                ans.add(a[i]);
            }
        }

        int b[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            b[i] = ans.get(i);
        }

        return b;
    }
}
