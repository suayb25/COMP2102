package DoubleLinkedList;

public class DoubleNode {
    int data;
    DoubleNode next;
    DoubleNode previous;

    /**
     * Constructor of DoubleNode
     * @param data
     */
    public DoubleNode(int data) {
        this.data = data;
        next = null;
        previous = null;
    }
}
