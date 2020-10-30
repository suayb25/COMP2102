package LinkedList;

public class CustomerLinkedList {
    Customer first;
    Customer last;
    int size;

    public CustomerLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    public void insertFirst(Customer x) {
        Customer newCustomer = x;
        if (first == null) {
            first = newCustomer;
            last = newCustomer;
        } else {
            newCustomer.next = first;
            first = newCustomer;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public String toString() {
        StringBuilder str = new StringBuilder("List with " + size + " elements: ");
        if (isEmpty()) {
            return str.append("None").toString();
        }
        Customer tmp = first;
        while (tmp != null) {
            str.append(tmp.name + " -> ");
            tmp = tmp.next;
        }
        return str.toString();
    }
}
