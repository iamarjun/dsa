package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 6, 7, 10 };
        int b[] = { 2, 3, 5, 6, 9, 8 };
        // int c[] = intersectionBrute(a, b);
        int c[] = intersectionOptimal(a, b);
        System.out.println(Arrays.toString(c));
    }

    private static int[] intersectionBrute(int[] a, int[] b) {

        int[] visited = new int[b.length];
        ArrayList<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j] && visited[j] == 0) {
                    intersection.add(a[i]);
                    visited[j] = 1;
                    break;
                }

                if (b[j] > a[i]) {
                    break;
                }
            }
        }

        int[] c = new int[intersection.size()];

        for (int k = 0; k < intersection.size(); k++) {
            c[k] = intersection.get(k);
        }

        return c;
    }

    private static int[] intersectionOptimal(int[] a, int[] b) {
        int i = 0, j = 0;

        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                intersection.add(a[i]);
                i++;
                j++;
            }
        }

        int[] c = new int[intersection.size()];

        for (int k = 0; k < intersection.size(); k++) {
            c[k] = intersection.get(k);
        }

        return c;
    }
}
