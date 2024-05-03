package linked_list;

public class Add1ToTheLinkedList {
    public static void main(String[] args) {
        int[] a = { 1, 6, 9 };
        var head = LinkedListHelper.arrayToLinkedList(a);
        head = addd1(head);
        LinkedListHelper.iterateLinkedList(head);

    }

    private static Node<Integer> add1(Node<Integer> head) {
        var nHead = reverse(head);
        int carry = 1;
        var temp = nHead;

        while (temp.next != null) {
            var newData = temp.data + carry;
            temp.data = newData % 10;
            carry = (newData) / 10;
            temp = temp.next;
        }

        if (carry > 0) {
            var newData = temp.data + carry;
            temp.data = newData % 10;
            carry = (newData) / 10;
            var node = new Node<>(carry);
            temp.next = node;
            temp = node;
        }

        var ogHead = reverse(nHead);

        return ogHead;
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }

        var nHead = reverse(head.next);
        var current = head;
        var front = current.next;
        front.next = current;
        current.next = null;
        return nHead;
    }

    private static Node<Integer> addd1(Node<Integer> head) {
        int carry = add1Recursive(head);
        if (carry > 0) {
            var node = new Node<>(carry);
            node.next = head;
            head = node;
        }
        return head;
    }

    private static int add1Recursive(Node<Integer> head) {
        if (head.next == null) {
            int newData = head.data + 1;
            head.data = newData % 10;
            return newData / 10;
        }
        int carry = add1Recursive(head.next);
        int newData = head.data + carry;
        head.data = newData % 10;
        return newData / 10;

    }
}
