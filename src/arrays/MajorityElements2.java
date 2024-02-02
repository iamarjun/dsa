package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MajorityElements2 {
    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 2, 2, 3, 3, 3 };
        // int b[] = majorityElementsBrute(a);
        int b[] = majorityElementsBetter(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] majorityElementsBrute(int a[]) {
        int n = Math.floorDiv(a.length, 3);
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (ans.isEmpty() || !ans.contains(a[i])) {
                for (int j = 0; j < a.length; j++) {
                    if (a[j] == a[i]) {
                        count++;
                    }

                    if (count > n) {
                        count = 0;
                        ans.add(a[i]);
                    }
                }
            }
        }

        int b[] = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            b[i] = ans.get(i);
        }

        return b;
    }

    private static int[] majorityElementsBetter(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Math.floorDiv(a.length, 3);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            if (map.get(a[i]) > n) {
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
