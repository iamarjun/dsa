package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int a[] = { 1, 2, -1, -2, 2, 0, -1 };
        var b = fourSumBrute(a, 0);
        var c = fourSumBetter(a, 0);
        var d = fourSumOptimal(a, 0);

        for (Integer[] integers : b) {
            System.out.println(Arrays.toString(integers));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (Integer[] integers : c) {
            System.out.println(Arrays.toString(integers));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for (Integer[] integers : d) {
            System.out.println(Arrays.toString(integers));
        }
    }

    private static List<Integer[]> fourSumBrute(int[] a, int target) {
        List<Integer[]> ans = new ArrayList<Integer[]>();
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < a.length; j++) {
                if (j != i + 1 && a[j] == a[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < a.length; k++) {
                    for (int l = k + 1; l < a.length; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == target) {
                            Integer[] temp = { a[i], a[j], a[k], a[l] };
                            Arrays.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static List<Integer[]> fourSumBetter(int[] a, int target) {
        Set<Integer> set = new HashSet<>();
        List<Integer[]> ans = new ArrayList<Integer[]>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    int l = target - (a[i] + a[j] + a[k]);
                    if (set.contains(l)) {
                        Integer[] temp = { a[i], a[j], a[k], l };
                        Arrays.sort(temp);
                        ans.add(temp);
                    }
                    set.add(a[k]);
                }
            }
        }
        return ans;
    }

    private static List<Integer[]> fourSumOptimal(int[] a, int target) {
        Arrays.sort(a);
        List<Integer[]> ans = new ArrayList<Integer[]>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int k = j + 1, l = a.length - 1;
                while (k < l) {
                    int sum = a[i] + a[j] + a[k] + a[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        Integer[] temp = { a[i], a[j], a[k], a[l] };
                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l && a[k] == a[k - 1]) {
                            k++;
                        }
                        while (k < l && a[j] == a[j + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
