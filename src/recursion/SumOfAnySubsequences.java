package recursion;

import java.util.Stack;

public class SumOfAnySubsequences {
    public static void main(String[] args) {
        
    }

    private static boolean sumOfAnySubsequence(int i, int[] a, Stack<Integer> ds, int sum, int target) {
        int n = a.length;
        if (i == n) {
            if (sum == target) {
                for (int j : ds) {
                    System.out.print(j);
                }
                System.out.println();
                return true;
            }
            return false;
        }

        ds.push(a[i]);
        sum += a[i];
        if (sumOfAnySubsequence(i + 1, a, ds, sum, target)) {
            return true;
        }

        ds.pop();
        sum -= a[i];
        if (sumOfAnySubsequence(i + 1, a, ds, sum, target)) {
            return true;
        }
        return false;
    }
}
