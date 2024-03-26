package linked_list;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.prev = null;
        this.next = next;
    }

}
