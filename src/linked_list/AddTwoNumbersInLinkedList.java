package linked_list;

public class AddTwoNumbersInLinkedList {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        var h1 = DLL.convertToDLL(a);

        int[] b = { 6, 7, 8, 9, 10 };
        var h2 = DLL.convertToDLL(b);

        var h3 = addNumbers(h1, h2);

        DLL.iterate(h3);

    }

    private static Node<Integer> addNumbers(Node<Integer> h1, Node<Integer> h2) {
        int carry = 0;
        Node<Integer> dummy = new Node<Integer>(-1);

        var t1 = h1;
        var t2 = h2;

        var current = dummy;

        while (t1 != null || t2 != null) {
            var n = ((t1 != null ? t1.data : 0) + (t2 != null ? t2.data : 0)) + carry;

            carry = n / 10;
            int data = n % 10;

            var node = new Node<>(data);
            current.next = node;
            node.prev = current;
            current = node;
            
            if (t1 != null) {
                t1 = t1.next;
            }

            if (t2 != null) {
                t2 = t2.next;
            }
        }

        var last = new Node<>(carry);
        current.next = last;

        return dummy.next;
    }

}
