package linked_list;

public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        var head = DLL.convertToDLL(a);
        // head = removeNthFromEnd(head, 6);
        head = removeNthFromEnd2(head, 6);
        DLL.iterate(head);
    }

    private static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        int count = 0;

        var temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        if (count == n) {
            return head.next;
        }

        temp = head;

        for (int i = 0; i < count - n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        temp.next.next.prev = temp;

        return head;
    }

    private static Node<Integer> removeNthFromEnd2(Node<Integer> head, int n) {
        var fast = head;
        var slow = head;


        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
