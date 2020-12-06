package bst;

public class Node<Item> {
    int key;
    Item data; // change this for other objects
    Node<Item> left = null;
    Node<Item> right = null;

    public Node(int key, Item name) {
        this.key = key;
        this.data = name;

    }

    @Override
    public String toString() {
        return ("Node(k= " + key + ", name= " + data.toString() + ")");
    }
}
