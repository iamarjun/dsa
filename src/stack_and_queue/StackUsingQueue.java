package stack_and_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {

    }

    private static class Stack1<T> {

        private Queue<T> q1;
        private Queue<T> q2;


        public Stack1() {
            this.q1 = new ArrayDeque<T>();
            this.q2 = new ArrayDeque<T>();
        }

        public void push(T item) {
            //push item into q2
            q2.offer(item);
            
            //copy all the items from q1 to q2
            while (!q1.isEmpty()) {
                T _item = q1.remove();
                q2.offer(_item);
            }

            Queue<T> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public T pop() {
            T item = q2.remove();
            return item;
        }

    }
    private static class Stack2<T> {

        private Queue<T> queue;

        public Stack2() {
            this.queue = new ArrayDeque<T>();
        }

        public void push(T item) {
            //push item into q2
            queue.offer(item);
            
            int i = queue.size() - 1;

            while (i >= 0) {
                T t = queue.remove();
                queue.offer(t);
                i--;
            }
        }

        public T pop() {
            T item = queue.remove();
            return item;
        }

    }
}
