package linked_list;

public class LL {

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private static Node<Integer> head;
    private static Node<Integer> tail = new Node<Integer>(null);

    public static void main(String[] args) {

        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        convertArrayToLinkedList(a);
        // iterate(); 
        deleteFirst();
        deleteLast();
        deleteAt(5);
        delete(6);

        insertFirst(-1);
        insertLast(10);
        insertAt(5, 5);
        insertBefore(4, 3);
        iterate();

        System.out.println("Head " + head.data);
        System.out.println("Tail " + tail.data);

    }

    private static void convertArrayToLinkedList(int[] a) {
        head = new Node<Integer>(a[0]);
        Node<Integer> current = head;
        for (int i = 1; i < a.length; i++) {
            Node<Integer> temp = new Node<Integer>(a[i]);
            current.next = temp;
            current = temp;
            tail = temp;
        }
    }

    private static void iterate() {
        Node<Integer> temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private static int length() {
        int count = 0;

        Node<Integer> temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;

    }

    // insertion
    private static void insertFirst(int k) {
        Node<Integer> temp = new Node<Integer>(k);
        var prevHead = head;
        head = temp;
        temp.next = prevHead;

    }

    private static void insertLast(int k) {
        var temp = new Node<Integer>(k);
        tail.next = temp;
        tail = temp;
    }

    private static void insertAt(int index, int k) {
        int count = 0;

        Node<Integer> temp = head;

        while (temp != null) {
            if (count == index - 1) {
                break;
            }

            temp = temp.next;
            count++;
        }

        var node = new Node<>(k);
        var old = temp.next;
        temp.next = node;
        node.next = old;
    }

    private static void insertBefore(int k, int l) {
        var current = head;

        while (current != null) {
            if (current.next == null || current.next.data == null) {
                return;
            }

            if (current.next.data == k) {
                break;
            }

            current = current.next;
        }

        var node = new Node<>(l);
        var oldNext = current.next;
        current.next = node;
        node.next = oldNext;
    }

    // deletion
    private static void deleteFirst() {
        var prevHead = head;
        head = prevHead.next;
        prevHead = null;
    }

    private static void deleteLast() {
        var current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        tail = current;
        tail.next = null;
        
    }

    private static void deleteAt(int k) {
        int count = 0;

        Node<Integer> temp = head;

        while (temp != null) {
            if (count == k - 1) {
                break;
            }

            temp = temp.next;
            count++;
        }

        var item = temp.next;
        temp.next = item.next;
        item = null;
    }

    private static void delete(int k) {
        var temp = head;

        while (temp != null) {
            if (temp.next == null || temp.next.data == null) {
                return;
            }
            if (temp.next.data == k) {
                break;
            }
            temp = temp.next;
        }

        var item = temp.next;
        temp.next = temp.next.next;
        item.next = null;
    }

}
