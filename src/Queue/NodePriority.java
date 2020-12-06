package Queue;

public class NodePriority<T> {
    public T item;
    public NodePriority<T> next;
    public int priority;

    public NodePriority(T item) {
        this.item = item;
        this.priority = 0;
    }

    public NodePriority(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    public T getItem() {
        return item;
    }


    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
