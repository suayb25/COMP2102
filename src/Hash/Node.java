package Hash;

public class Node<Item> {
    Item data;
    Node next;

    public Node(Item data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}