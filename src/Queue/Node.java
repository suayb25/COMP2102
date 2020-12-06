package Queue;

public class Node<T> {
    public T item;
    public Node<T> next;

    public Node(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }


}
