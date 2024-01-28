package arrays;

import java.util.ArrayList;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        int a[][] = {
                { 1, 2, 3, 4 },
                { 12, 13, 14, 5 },
                { 11, 16, 15, 6 },
                { 10, 9, 8, 7 },
        };

        int b[] = spiralTraverse(a);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    private static int[] spiralTraverse(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                ans.add(a[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(a[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(a[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(a[i][left]);
                }
                left++;
            }
        }

        int b[] = new int[ans.size()];

        for (int i = 0; i < b.length; i++) {
            b[i] = ans.get(i);
        }

        return b;
    }
}
