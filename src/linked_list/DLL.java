package linked_list;

public class DLL {

    public static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.prev = null;
            this.next = next;
        }

    }

    private static Node<Integer> head;
    private static Node<Integer> tail;

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        convertToDLL(a);
        deleteFirst();
        deleteLast();
        deleteAt(5);
        delete(6);

        insertFirst(-1);
        insertLast(10);
        insertLast(11);
        insertLast(12);
        insertAt(5, 5);
        
        iterate();

        System.out.println("Head: " + head.data);
        System.out.println("Tail: " + tail.data);
    }

    
    private static void insertAt(int i, int j) {
        var count = 0;
        var current = head;
        while (current != null) {
            if (count == i - 1) {
                break;
            }
            count++;
            current = current.next;
        }

        var node = new Node<>(j);

        current.prev.next = node;
        node.prev = current.prev;
        node.next = current;
        current.prev = node;

    }
    
    private static void insertLast(int i) {
        var node = new Node<>(i);
        tail.next = node;
        tail = tail.next;
        node.prev = tail;
    }
    
    private static void insertFirst(int i) {
        var node = new Node<>(i);
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private static void deleteAt(int i) {
        var count = 0;
        var current = head;
        while (current != null) {
            if (count == i) {
                break;
            }
            count++;
            current = current.next;
        }

        var temp = current;
        temp.prev.next = current.next;
        temp.next.prev = current.prev;
        current = null;
        
    }

    private static void delete(int i) {
        var current = head;

        while (current != null) {
            if (current.data == i) {
                break;
            }

            current = current.next;
        }

        var temp = current;
        temp.prev.next = current.next;
        temp.next.prev = current.prev;
        current = null;

    }

    private static void deleteLast() {
        tail = tail.prev;
        tail.next = null;
    }

    private static void deleteFirst() {
        head = head.next;
        head.prev = null;
    }

    private static void convertToDLL(int[] a) {
        head = new Node<>(a[0]);
        var current = head;
        for (int i = 1; i < a.length; i++) {
            var node = new Node<>(a[i]);
            node.prev = current;
            current.next = node;
            current = node;
        }
        tail = current;
    }

    private static void iterate() {
        var current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
