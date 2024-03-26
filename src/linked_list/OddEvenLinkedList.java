package linked_list;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 , 7};
        var h = DLL.convertToDLL(a);
        h = oddEven(h);
        DLL.iterate(h);
    }

    private static Node<Integer> oddEven(Node<Integer> head) {
        var odd = head;
        var even = head.next;
        var _even = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = odd.next;
        }

        odd.next = _even;
        return head;
    }


}
