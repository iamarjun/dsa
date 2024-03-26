package linked_list;

public class ReverseDLL {

    private static Node<Integer> head;
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        head = DLL.convertToDLL(a);
        DLL.iterate(head);

        reverse();

        System.out.println("Reversed");
        DLL.iterate(head);
    }

    private static void reverse() {
        var current = DLL.head;

        while (current != null) {
            var _next = current.next;
            var _prev = current.prev;
            current.next = _prev;
            current.prev = _next;
            if (_next == null) {
                head = current;
            }
            current = _next;

        }

    }
}
