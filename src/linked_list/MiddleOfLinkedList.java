package linked_list;

public class MiddleOfLinkedList {
    
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        var head = LinkedListHelper.arrayToLinkedList(a);
        LinkedListHelper.iterateLinkedList(head);
        var middle = middleItem(head);
        System.out.println(middle.data);
    }


    private static Node<Integer> middleItem(Node<Integer> head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
