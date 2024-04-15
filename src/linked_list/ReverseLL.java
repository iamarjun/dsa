package linked_list;

public class ReverseLL {

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        var head = arrayToLinkedList(a);
        // iterateLinkedList(head);
        // head = reverse(head);
        head = reverseRecursive(head);
        iterateLinkedList(head);

    }

    private static void iterateLinkedList(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    private static Node<Integer> arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Node<Integer> head = new Node<Integer>(arr[0]);
        Node<Integer> current = head;

        for (int i = 1; i < arr.length; i++) {
            Node<Integer> newNode = new Node<>(arr[i]);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> prev = null;
        var temp = head;
        var front = head.next;

        while (temp.next != null) {
            temp.next = prev;
            prev = temp;
            temp = front;
            front = temp.next;
        }

        temp.next = prev;
        prev = temp;
        temp = front;
        
        return prev;
    }

    private static Node<Integer> reverseRecursive(Node<Integer> current) {

        if (current == null || current.next == null) {
            return current;
        }

        var nHead = reverseRecursive(current.next);
        var front = current.next;
        front.next = current;
        current.next = null;
        return nHead;
    }
}
