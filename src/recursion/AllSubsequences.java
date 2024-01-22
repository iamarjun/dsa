package recursion;

import java.util.ArrayDeque;

public class AllSubsequences {
    public static void main(String[] args) {
        
    }

     // 2^n * n
    private static void allSubsequences(int i, int[] a, ArrayDeque<Integer> ans) {
        int n = a.length;
        if (i == n) {
            for (int z : ans) {
                System.out.print(z);
            }
            System.out.println();
            return;
        }

        ans.push(a[i]);
        allSubsequences(i + 1, a, ans);
        ans.pop();
        allSubsequences(i + 1, a, ans);
    }

}
