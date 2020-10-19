package LinkedList;

public class MyLinkedList {
    Node first;
    Node last;
    int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

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

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = first;
        first = first.next;
        size--;
        return tmp;
    }

    public void removeLast() {
        if (isEmpty() || first.next == null) {
            return;
        }
        Node current = first;
        while (current.next.next != null) {
            current = current.next;
        }
        /*for(int i=0;i<size-2;i++){
            current=current.next;
        }*/
        last = current;
        last.next = null;
        size--;
    }

    public String search(int x) {//linear search
        Node current = first;
        int index = 1;
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
