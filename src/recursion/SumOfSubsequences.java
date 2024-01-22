package recursion;

import java.util.Stack;

public class SumOfSubsequences {
    public static void main(String[] args) {
        
    }

    private static void sumOfSubsequence(int i, int[] a, Stack<Integer> ds, int sum, int target) {
        int n = a.length;
        if (i == n) {
            if (sum == target) {
                for (int j : ds) {
                    System.out.print(j);
                }
                System.out.println();
                return;
            }
            return;
        }

        ds.push(a[i]);
        sum += a[i];
        sumOfSubsequence(i + 1, a, ds, sum, target);
        ds.pop();
        sum -= a[i];
        sumOfSubsequence(i + 1, a, ds, sum, target);

    }
}
