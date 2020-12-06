package Queue;

public class GenericLinkedPriorityQueue<T> {
    private int size;
    private NodePriority<T> first;
    private NodePriority<T> last;

    public GenericLinkedPriorityQueue() {
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

    public void enqueue(T entry, int priority) {
        NodePriority<T> newNode = new NodePriority(entry, priority);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void enqueueWithPriority(T entry, int priority) {
        NodePriority<T> newNode = new NodePriority(entry,priority);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        }else{
            NodePriority<T> temp = first;
            while (temp.next!=null){
                if(temp.next.priority >= newNode.priority){
                    temp=temp.next;
                }else{
                    break;
                }
            }
            if(temp==first){
                newNode.next = temp;
                first=newNode;
            }else{
                newNode.next = temp.next;
                temp.next=newNode;
                if(temp==last){
                    last=newNode;
                }
            }
        }
        size++;
    }

    public String maxPriorityNode() {
        NodePriority<T> maxPriority = first;
        NodePriority<T> temp = first.next;
        while (temp != null) {
            if (temp.priority > maxPriority.priority) {
                maxPriority = temp;
            }
            temp = temp.next;
        }
        return "Item= " + maxPriority.item + " Priority= " + maxPriority.priority;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Stack underflow");
        }
        NodePriority<T> tmp = first;
        first = first.next;
        tmp.next = null;
        size--;
        return tmp.item;                // return the saved item
    }

}
