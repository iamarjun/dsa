package linked_list;

abstract public class LinkedListHelper {
    
    public static void iterateLinkedList(Node<Integer> head) {
        Node<Integer> current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static Node<Integer> arrayToLinkedList(int[] arr) {
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
}
