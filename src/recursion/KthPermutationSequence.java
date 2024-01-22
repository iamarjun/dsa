package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class KthPermutationSequence {

    public static void main(String[] args) {
        var n = 4;
        var freq = new int[n]; 
        var result = new ArrayList<ArrayList<Integer>>();
        // permutation(3, freq, new ArrayList<Integer>(), result);
        System.out.println(result);
        kthPerumtation(4, 15);
    }

    //brute force
    private static void permutation(int n, int[] freq, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> result) {
        
        if (ds.size() == n) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (freq[i] == 0) {
                freq[i] = 1;
                ds.add(i + 1);
                permutation(n, freq, ds, result);
                ds.remove(ds.size() - 1);
                freq[i] = 0;
            }
        }
    }

    // n^2  
    private static void kthPerumtation(int n, int k) {
        var fact = 1;
        var numbers = new ArrayList<Integer>();

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }

        numbers.add(n);
        // kth means k - 1 in a 0 based index 
        k = k - 1;

        String ans = "";

        while (true) {
            System.out.println("K " + k);
            System.out.println("Factorial " + fact);
            ans += numbers.get(k / fact);
            numbers.remove(k / fact);

            if (numbers.size() == 0) {
                break;
            }

            k = k % fact;
            fact = fact / numbers.size();
        }

        System.out.println(ans);

    }
}
