package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int a[][] = { { 3, 5 }, { 2, 4 }, { 6, 7 }, { 1, 3 } };
        ArrayList<int[]> b = merge(a);
        for (int[] e : b) {
            System.out.println(Arrays.toString(e));
        }
    }

    private static ArrayList<int[]> merge(int[][] a) {
        ArrayList<int[]> ans = new ArrayList<>();

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[0] - arg1[0];
            }
        });

        for (int i = 0; i < a.length; i++) {
            
            if (ans.isEmpty() || a[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(a[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], a[i][1]);
            }
        }

        return ans;
    }
}
