package linked_list;

public class Sort0s1s2sInALinkedList {
    public static void main(String[] args) {
        int[] a = { 1, 0, 1, 1, 0, 2, 2, 0, 0, 1, 2, 1, 2, 0 };
        var head = DLL.convertToDLL(a);
        // sortList(head);
        head = sort(head);
        DLL.iterate(head);
    }

    private static Node<Integer> sortList(Node<Integer> head) {
        int count[] = { 0, 0, 0 };
        var temp = head;
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }

        int i = 0;
        temp = head;
        while (temp != null) {
            if (count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                count[i]--;
                temp = temp.next;
            }
        }

        return head;
    }

    private static Node<Integer> sort(Node<Integer> head) {
        var zeroD = new Node<Integer>(-1);
        var oneD = new Node<Integer>(-1);
        var twoD = new Node<Integer>(-1);

        var zero = zeroD;
        var one = oneD;
        var two = twoD;

        var temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null;

        head = zeroD.next;

        return head;
    }
}
