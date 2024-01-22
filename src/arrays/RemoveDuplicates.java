package arrays;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int a[] = { 1, 1, 2, 2, 2, 3, 4, 4, 4, 5 };
        removeDuplicatesOptimal(a);
        System.out.println(Arrays.toString(a));
        removeDuplicatesBrute(a);
        System.out.println(Arrays.toString(a));
    }

    // Brute -
    private static void removeDuplicatesBrute(int[] a) {
        var set = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        var iterator = set.iterator();

        int count = 0;
        while (iterator.hasNext()) {
            a[count++] = iterator.next();
            iterator.remove();
        }

    }

    // optimal - 2 pointer
    private static void removeDuplicatesOptimal(int[] a) {
        int i = 0;

        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[++i] = a[j];
            }
        }
    }
}
