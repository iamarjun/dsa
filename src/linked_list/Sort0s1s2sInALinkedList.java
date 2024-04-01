package linked_list;

public class Sort0s1s2sInALinkedList {
    public static void main(String[] args) {

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
        var zeroD = new Node<Integer>(0);
        var oneD = new Node<Integer>(0);
        var twoD = new Node<Integer>(0);

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
        one.prev = zero;
        two.next = null;
        two.prev = one;

        head = zeroD.next;

        return head;
    }
}
