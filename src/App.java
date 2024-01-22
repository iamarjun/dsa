import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        var x = s.nextInt();
        var ans = new ArrayList<ArrayList<Integer>>();
        int[] a = { 1, 2, 3 };
        // var count = countSubsequence(0, a, 0, 3);
        // qs(a, 0, a.length - 1);
        // powerSet(a);
        boolean[] b = new boolean[a.length];
        // permute(0, a, ans);

        // System.out.println(count);
        s.close();
    }

    // print all subsequences O(n*2^n)
    private static void powerSet(int[] a) {
        var set = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < Math.pow(2, a.length) - 1; i++) {
            var p = new ArrayList<Integer>();
            for (int j = 0; j < a.length - 1; j++) {
                if ((i & 1 << j) != 0) {
                    p.add(a[j]);
                }
            }
            set.add(p);
        }

        System.out.println(set);
    }

}
