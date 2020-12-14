package Queue;

public class GenericLinkedQueue<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public GenericLinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T entry) {
        Node<T> newNode = new Node(entry);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack underflow");
        }
        Node<T> tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;                // return the saved item
    }
}
