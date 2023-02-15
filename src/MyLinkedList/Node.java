package MyLinkedList;

public class Node<T> {
    public Node<T> next;
    T data;
    Node(T data) {
        this.data = data;
    }
}