package stack_and_queue;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInAHistogram {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3, 1};
        int b = largestRect(a);
        System.out.println(b);
    }

    private static int largestRect(int[] a) {
        int n = a.length;
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmallest[i] = 0;
            } else {
                leftSmallest[i] = stack.peek() + 1;
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && a[stack.peek()] > a[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightSmallest[i] = i;
            } else {
                rightSmallest[i] = stack.peek() - 1;
            }

            stack.push(i);
        }

        int area = 0;

        System.out.println(Arrays.toString(leftSmallest));
        System.out.println(Arrays.toString(rightSmallest));

        for (int i = 0; i < n; i++) {
            int j = ((rightSmallest[i] - leftSmallest[i]) + 1) * a[i]; 
            area = Math.max(area, j);
        }

        return area;
    }
}
