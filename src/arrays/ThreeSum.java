package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] a = { -1, 0, 1, 2, -1, -4 };
        var b = threeSum(a);
        for (Integer[] integers : b) {
            System.out.println(Arrays.toString(integers));
        }
    }

    private static Set<Integer[]> threeSumBrute(int a[]) {
        Set<Integer[]> ans = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        Integer b[] = { a[i], a[j], a[k] };
                        Arrays.sort(b);
                        ans.add(b);
                    }
                }
            }
        }

        return ans;
    }

    private static Set<Integer[]> threeSumBetter(int a[]) {
        Set<Integer[]> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            set.clear();
            for (int j = i + 1; j < a.length; j++) {
                int k = 0 - (a[i] + a[j]);
                if (set.contains(k)) {
                    Integer[] temp = new Integer[] { a[i], a[j], k };
                    Arrays.sort(temp);
                    ans.add(temp);
                }
                set.add(a[j]);
            }
        }

        return ans;
    }

    private static Set<Integer[]> threeSum(int[] a) {
        Set<Integer[]> ans = new HashSet<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int j = i + 1, k = a.length - 1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    Integer[] temp = new Integer[] { a[i], a[j], a[k] };
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && a[j] == a[j - 1]) {
                        j++;
                    }

                    while (j < k && a[k] == a[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
