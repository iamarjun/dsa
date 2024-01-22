package recursion;

import java.util.ArrayList;

public class AllPermutations {
    public static void main(String[] args) {

    }

    private static void permutations(int[] a, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> result, boolean[] freq) {
        System.out.println("ds" + ds);
        System.out.println("result" + result);
        if (ds.size() == a.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < freq.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(a[i]);
                permutations(a, ds, result, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    private static void permute(int index, int[] a, ArrayList<ArrayList<Integer>> result) {
        if (index == a.length) {
            ArrayList<Integer> ds = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                ds.add(a[i]);
            }
            result.add(ds);
            return;
        }

        for (int i = index; i < a.length; i++) {
            swap(index, a, i); // swap
            permute(index + 1, a, result);
            swap(index, a, i); // reset swap
        }
    }

    private static void swap(int index, int[] a, int i) {
        int temp = a[i];
        a[i] = a[index];
        a[index] = temp;
    }

}
