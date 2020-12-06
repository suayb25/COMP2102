package Stack;

public class GenerickLLStack<T> {
    private int N; // size of the stack
    private Node<T> first;

    public GenerickLLStack() {
        N=0;
        first = null;
    }

    public GenerickLLStack(int n, Node<T> first) {
        N = n;
        this.first = first;
    }

    public GenerickLLStack(GenerickLLStack A)  {

        Node tmpFirst = new Node(A.first.getItem());
        this.first = tmpFirst;
        this.N++;
        Node<Integer> currentA= A.first.next;
        while (currentA!=null){
            tmpFirst.next = new Node(currentA.getItem());
            tmpFirst = tmpFirst.next;
            currentA = currentA.next;
            this.N++;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T entry) {
        Node<T> oldfirst = first;
        first = new Node<T>(entry);
        first.next = oldfirst;
        N++;
    }

    public T pop() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack underflow");
        T item = first.getItem();        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }

    public String toString() {
        StringBuilder str = new StringBuilder("List with " + N + " elements: ");
        if (isEmpty()) {
            return str.append("None").toString();
        }
        Node tmp = first;
        while (tmp != null) {
            str.append(tmp.getItem() + " -> ");
            tmp = tmp.next;
        }
        return str.toString();
    }

}