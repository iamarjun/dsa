package stack_and_queue;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QueueUsingArrays {
    public static void main(String[] args) {
        
    }

    private static class Queue<T> {

        private T[] queue;
        private int size;
        private int currentIndex;
        private int top;

        @SuppressWarnings("unchecked")
        public Queue() {
            this.size = 50;
            this.currentIndex = 0;
            this.top = 0;
            this. queue = (T[]) Array.newInstance(queue.getClass(), size);
        
        }

        @SuppressWarnings("unchecked")
        public Queue(int size) {
            this.size = size;
            this.currentIndex = 0;
            this.top = 0;
            this. queue = (T[]) Array.newInstance(queue.getClass(), size);
        }


        public void push(T item) {
            if (currentIndex == size - 1) {
                this.size = size * 2;
                this.queue = Arrays.copyOf(queue, size);
            }
            queue[currentIndex++ % size] = item;
        }

        public T pop() {
            T item = queue[top++];
            return item;
        }

        public T top() {
            T item = queue[top];
            return item;
        }

        public int size() {
            return (currentIndex - top) + 1;
        }

        public boolean isEmpty() {
            return currentIndex == top;
        }
    }
}
