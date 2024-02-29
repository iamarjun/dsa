package stack_and_queue;

import java.util.Stack;

public class QueueUsingStack {

    private static class Queue<T> {

        private Stack<T> s1;
        private Stack<T> s2;

        public Queue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void push(T item) {
            // s1 -> s2
            while (!s1.empty()) {
                s2.push(s1.pop());
            }

            // item -> s1
            s1.push(item);

            // s2 -> s2
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }

        public T pop() {
            T item = s1.pop();
            return item;
        }
    }

    private static class Queue1<T> {

        private Stack<T> inputStack;
        private Stack<T> outpStack;

        public Queue1() {
            this.inputStack = new Stack<>();
            this.outpStack = new Stack<>();
        }

        //O(1)
        public void push(T item) {
            inputStack.push(item);
        }

        //O(1)+ amortised
        public T pop() {
            T item;
            if (outpStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outpStack.push(inputStack.pop());
                }
            }
            item = outpStack.pop();
            return item;
        }

        //O(1)+ amortised
        public T top() {
            T item;
            if (outpStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outpStack.push(inputStack.pop());
                }
            }
            item = outpStack.peek();
            return item;
        }
    }
}
