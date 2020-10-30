package LinkedList;

public class MyLinkedList {
    Node first;
    Node last;
    int size;

    /**
     * Init MyLinkedList with specified first node, last node and size
     *
     * "first" the first node of list
     * "last" the last node of list
     * "size" size the size of list
     */
    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Insert an element at the first of the list
     *
     * @param x element to be added
     */
    public void insertFirst(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    /**
     * Insert an element at the last of the list
     *
     * @param x element to be added
     */
    public void insertLast(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAfter(Node p, int x) {
        Node newNode = new Node(x);
        if (p == null || size == 0) {
            return;
        }
        if (p == last) {
            insertLast(x);
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

    /**
     * Inserts a new node at a specified position of the list
     *
     * @param data     data to be stored in a new node
     * @param position position at which a new node is to be inserted
     */
    public void insertNth(int data, int position) { //insert with position
        checkBounds(position, 0, size);
        Node newNode = new Node(data);
        if (first == null) { // the list is empty
            first = newNode;
            size++;
            return;
        } else if (position == 0) { // insert first
            newNode.next = first;
            first = newNode;
            size++;
            return;
        }
        Node current = first;
        for (int i = 0; i < position - 1; ++i) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * Deletes a node at the first
     */
    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = first;
        first = first.next;
        size--;
        return tmp;
    }

    /**
     * Deletes a node at the last
     */
    public void removeLast() {
        Node current = first;
        if (isEmpty()) {
            return;
        }else if(first.next==null){
            first=null;
            last=null;
            size--;
            return;
        }
        while (current.next != last) {
            current = current.next;
        }
        /*for(int i=0;i<size-2;i++){
            current=current.next;
            }*/
        last = current;
        last.next = null;
        size--;
    }

    /**
     * Returns key value and its index if the value x in the list.
     *
     * @param x the value to be searched.
     * @return founded value and its index.
     */
    public String search(int x) {//linear search
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.data == x) {
                return "We found " + x + " at index: " + index;
            } else {
                index++;
            }
            current = current.next;
        }
        return "We did not found " + x;
    }

    /**
     * Returns Node if the value in the list.
     *
     * @param value the value to be searched.
     * @return founded Node.
     */
    public Node searchNode(int value) {
        Node tmp = first;
        while (tmp != null) {
            if (tmp.data == value)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public void insertSorted(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
            size++;
            return;
        } else if (first.data >= newNode.data) {//insert first
            newNode.next = first;
            first = newNode;
            size++;
            return;
        }
        Node current = first;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }
        if (current == last) {
            last.next = newNode;
            last = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Calculates sum of all values in the list.
     *
     * @return sum of all values in the list.
     */
    public int getSum() {
        Node current = first;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("List with " + size + " elements: ");
        if (isEmpty()) {
            return str.append("None").toString();
        }
        Node tmp = first;
        while (tmp != null) {
            str.append(tmp.data + " -> ");
            tmp = tmp.next;
        }
        return str.toString();
    }


    /**
     * @param position to check position
     * @param low      low index
     * @param high     high index
     * @throws IndexOutOfBoundsException if {@code position} not in range {@code low} to {@code high}
     */
    public void checkBounds(int position, int low, int high) {
        if (position > high || position < low) {
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    public void insertAfterV2(int previous, int x) { //multiple same data problem
        Node newNode = new Node(x);
        Node current = first;
        if (current == null || size == 0) {
            return;
        }
        while (current != null) {
            if (current.data == previous) {
                break;
            } else {
                current = current.next;
            }
        }
        if (current == last) {
            insertLast(x);
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}
