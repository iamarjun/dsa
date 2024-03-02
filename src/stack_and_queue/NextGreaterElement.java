package stack_and_queue;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

    }

    private static int[] nextGreaterElement(int[] a) {
        Stack<Integer> stack = new Stack<>();

        int n = a.length;
        int[] nge = new int[a.length];

        for (int i = (2 * n) - 1; i >= 0 ; i++) {

            while (!stack.isEmpty() && a[i % n] < stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = stack.peek();
                }
            }

            stack.push(a[i % n]);
        }

        return nge;
    }
}
