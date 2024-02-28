package stack_and_queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StackUsingArray {
    public static void main(String[] args) {
        
    }

    private static class Stack<T> {

        private T[] stack;
        private int size;
        private int currentSize;

        @SuppressWarnings("unchecked")
        public Stack() {
            this.size = 50;
            this.currentSize = 0;
            this.stack = (T[]) Array.newInstance(stack.getClass(), size);
        }

        @SuppressWarnings("unchecked")
        public Stack(int size) {
            this.size = size;
            this.currentSize = 0;
            this.stack = (T[]) Array.newInstance(stack.getClass(), size);
        }

        public void push(T item) {
            if (currentSize == size) {
                size = size * 2;
                this.stack = Arrays.copyOf(stack, size);
            }
            stack[currentSize++] = item;
        }

        public T pop() {
            T item = stack[currentSize--];
            return item;
        }

        public T top() {
            T item = stack[currentSize];
            return item;
        }

        public int size() {
            return currentSize + 1;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }
    }
}
