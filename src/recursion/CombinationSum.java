package recursion;

import java.util.ArrayList;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        
    }

     private static void combinationSum(int[] a, ArrayList<ArrayList<Integer>> combination, Stack<Integer> ds, int i,
            int target) {
        if (i == a.length) {
            if (target == 0) {
                combination.add(new ArrayList<>(ds));
            }
            return;
        }

        var p = a[i];
        if (p <= target) {
            ds.push(p);
            combinationSum(a, combination, ds, i, target - p);
            ds.pop();
        }
        combinationSum(a, combination, ds, i + 1, target);
    }
    
    private static void combinationSum(int[] a, int index, int sum, ArrayList<Integer> sums) {
        if (index == a.length) {
            sums.add(sum);
            return;
        }

        combinationSum(a, index + 1, sum + a[index], sums);
        combinationSum(a, index + 1, sum, sums);
    }
}
