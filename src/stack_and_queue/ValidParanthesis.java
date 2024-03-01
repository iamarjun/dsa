package stack_and_queue;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {

    }

    private static boolean validParanthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }

                if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }

                if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
