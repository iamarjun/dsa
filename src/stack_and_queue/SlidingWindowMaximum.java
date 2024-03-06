package stack_and_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int a[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int b[] = max(a, 3);
        System.out.println(Arrays.toString(b));
    }

    private static int[] max(int[] a, int k) {
        ArrayList<Integer> temp = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {
            

            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
                dq.removeLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                temp.add(a[dq.peekFirst()]);
            }
        }

        return temp.stream().mapToInt(t -> t).toArray();
    }
}
