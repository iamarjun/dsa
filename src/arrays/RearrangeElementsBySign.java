package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeElementsBySign {
    public static void main(String[] args) {
        int a[] = { 3, 1, -2, -5, 2, -4 };
        int b[] = rearrangeElementsBySignBrute(a);
        System.out.println(Arrays.toString(b));
    }

    private static int[] rearrangeElementsBySignBrute(int a[]) {
        ArrayList<Integer> positive = new ArrayList<>(), negative = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                positive.add(a[i]);
            } else {
                negative.add(a[i]);
            }
        }

        if (positive.size() < negative.size()) {
            for (int i = 0; i < positive.size(); i++) {
                a[i * 2] = positive.get(i);
                a[(i * 2) + 1] = negative.get(i);
            }

            int index = positive.size() * 2;
            for (int i = positive.size(); i < negative.size(); i++) {
                a[index++] = positive.get(i);
            }
        } else {
            for (int i = 0; i < negative.size(); i++) {
                a[i * 2] = positive.get(i);
                a[(i * 2) + 1] = negative.get(i);
            }

            int index = negative.size() * 2;
            for (int i = negative.size(); i < positive.size(); i++) {
                a[index++] = negative.get(i);
            }
        }

        return a;
    }

    private static int[] rearrangeElementsBySign(int[] a) {
        int ans[] = new int[a.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int i = 0; i < ans.length; i++) {
            if (a[i] > 0) {
                ans[positiveIndex] = a[i];
                positiveIndex += 2;
            } else {
                ans[negativeIndex] = a[i];
                negativeIndex += 2;
            }
        }

        return ans;
    }
}
