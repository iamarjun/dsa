package arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int a[] = {1, 0, 2, 3, 2, 0, 0, 1, 5, 1};
        moveZeroesToEnd(a);
        System.out.println(Arrays.toString(a));
    }

    private static void moveZeroesToEnd(int[] a) {
        int j = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }

        for (int i = j + 1; i < a.length; i++) {
            if (a[i] != 0) {
                var temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }

       
    }
}
