package linked_list;

public class LinkedListPalindrome {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 4, 3, 2 };
        var head = LinkedListHelper.arrayToLinkedList(a);
        var b = isPalindrome(head);
        System.out.println(b);
        LinkedListHelper.iterateLinkedList(head);
    }

    private static boolean isPalindrome(Node<Integer> head) {
        
        var slow = head;
        var fast = head;

        while (fast.next != null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var newHead = reverse(slow.next);

        var start = head;
        var end = newHead;
        while (start != end) {
            if (start.data != end.data) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        
        return true;
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        var newHead = reverse(head.next);
        var current = head;
        var next = current.next;
        next.next = current;
        current.next = null;
        return newHead;
    }

}


