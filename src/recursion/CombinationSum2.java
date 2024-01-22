package recursion;

import java.util.ArrayList;
import java.util.Stack;

public class CombinationSum2 {
    public static void main(String[] args) {

    }

    private static void combinationSum2(int[] a, int index, ArrayList<ArrayList<Integer>> combination,
            Stack<Integer> ds, int target) {
        if (index == a.length) {
            if (target == 0) {
                combination.add(new ArrayList<>(ds));
            }
        }

        for (int i = index; i < a.length; i++) {
            if (i > index && a[i] == a[i + 1]) {
                continue;
            }
            if (a[i] > target) {
                break;
            }
            var p = a[i];
            ds.push(p);
            combinationSum2(a, i + 1, combination, ds, target - p);
            ds.pop();
        }
    }
}
