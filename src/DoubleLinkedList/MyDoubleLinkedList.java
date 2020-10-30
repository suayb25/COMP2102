package DoubleLinkedList;

public class MyDoubleLinkedList {
    DoubleNode first;
    DoubleNode last;
    int size;

    /**
     * Init MyDoubleLinkedList with specified first node, last node and size
     *
     * "first" the first node of list
     * "last"  the last node of list
     * "size"  size the size of list
     */
    public MyDoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert an element at the first of the list
     *
     * @param a element to be added
     */
    public void insertFirst(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (last == null) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    /**
     * Insert an element at the last of the list
     *
     * @param a element to be added
     */
    public void insertLast(int a) {
        DoubleNode newNode = new DoubleNode(a);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    /**
     * Deletes a node at the first
     *
     * @return deleted node's int value
     */
    public int removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }

        int r = first.data;
        first = first.next;
        if (first == null) { //control if it becomes empty
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return r;
    }

    /**
     * Deletes a node at the last
     *
     * @return deleted node's int value
     */
    public int removeLast() { // you can also return int
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int r = last.data;
        last = last.previous;
        if (last == null) { //control if it becomes empty
            first = null;
        } else {
            last.next = null;
        }
        size--;
        return r;
    }

    public int remove(DoubleNode n) {
        if (isEmpty() || n == null) {
            throw new java.util.NoSuchElementException();
        }
        if (n == first) {
            return removeFirst();
        } else if (n == last) {
            return removeLast();
        } else {
            DoubleNode back = n.previous;
            DoubleNode front = n.next;
            back.next = front;
            front.previous = back;
            size--;
            return n.data; //n.getElement();
        }
    }

    public void insertAfter(int x, DoubleNode prev) {
        if (prev == null){
            throw new java.util.NoSuchElementException();
        }else if (prev==last){
            insertLast(x);
            return;
        }
        DoubleNode newNode = new DoubleNode(x);

        newNode.next = prev.next;
        newNode.previous = prev;

        prev.next.previous = newNode;
        prev.next = newNode;
        size++;
    }

    public void insertMiddle(int x){
        if(isEmpty() || size ==1){
            return;
        }
        DoubleNode newNode = new DoubleNode(x);
        DoubleNode current = first;
        for (int i=0;i<(size/2)-1;i++){
            current = current.next;
        }
        newNode.next = current.next;
        newNode.previous = current;

        current.next.previous = newNode;
        current.next = newNode;
        size++;
    }

    public void print() {
        DoubleNode tmp = this.first;
        while (tmp != null) {
            System.out.print(tmp.data + "->");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * Returns Node if the value in the list.
     *
     * @param value the value to be searched.
     * @return founded Node.
     */
    public DoubleNode search(int value) {
        DoubleNode tmp = first;
        while (tmp != null) {
            if (tmp.data == value)
                return tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public void swap(DoubleNode first, DoubleNode second) {
        if (first == second || first == null || second == null || isEmpty()) {
            return;
        }
        boolean k = false;

        DoubleNode current = first;
        while (current != null) { // understand if first and second is reverse
            if (current.data == second.data) {
                k = true;
                break;
            }
            current = current.next;
        }

        if (!k) { //k==false
            DoubleNode tmp = first;
            first = second;
            second = tmp;
        }

        DoubleNode next1 = first.next;
        DoubleNode previous2 = second.previous;
        if (first == this.first && second == last) { //swap first and last

            second.next = next1;
            next1.previous = second;

            first.previous = previous2;
            previous2.next = first;
            this.first = second;
            this.first.previous = null;
            last = first;
            last.next = null;

        } else if (first == this.first) { // must set new first
            DoubleNode next2 = second.next;

            second.next = next1;
            next1.previous = second;

            first.previous = previous2;
            first.next = next2;
            next2.previous = first;
            previous2.next = first;
            this.first = second;
            this.first.previous = null;
        } else if (second == last) { // must set new last
            DoubleNode previous1 = first.previous;

            second.previous = previous1;
            second.next = next1;
            next1.previous = second;
            previous1.next = second;

            first.previous = previous2;
            previous2.next = first;
            last = first;
            last.next = null;
        } else if (first.next == second) { //if nodes are side by side
            DoubleNode previous1 = first.previous;
            DoubleNode next2 = second.next;

            second.previous = previous1;
            second.next = first;

            first.previous = second;
            first.next = next2;
            next2.previous = first;
            previous1.next = second;

        } else { //if nodes are not side by side, any of them are not first or last
            DoubleNode previous1 = first.previous;
            DoubleNode next2 = second.next;

            second.previous = previous1;
            second.next = next1;
            next1.previous = second;
            previous1.next = second;

            first.previous = previous2;
            first.next = next2;
            next2.previous = first;
            previous2.next = first;
        }
    }


    /**
     * @param a first DoubleLinkedList for concatenation
     * @param b second DoubleLinkedList for concatenation
     * @return
     */
    public MyDoubleLinkedList concat(MyDoubleLinkedList a,MyDoubleLinkedList b){
        MyDoubleLinkedList newDL = new MyDoubleLinkedList();
        //newDL = a; // not do that
        //newDL.first=a.first;
        //newDL.last=a.last;
        //newDL.last.next=b.first;
        //newDL.last=b.last;

        DoubleNode current= a.first;
        while (current!=null){
            newDL.insertLast(current.data);
            current = current.next;
        }
        current= b.first;
        while (current!=null){
            newDL.insertLast(current.data);
            current = current.next;
        }
        return newDL;
    }

    /**
     * @param a first DoubleLinkedList for union
     * @param b second DoubleLinkedList for union
     * @return
     */
    public MyDoubleLinkedList union(MyDoubleLinkedList a,MyDoubleLinkedList b){
        MyDoubleLinkedList newDL = new MyDoubleLinkedList();

        DoubleNode currentA= a.first;
        while (currentA!=null){
            boolean k = true;
            DoubleNode currentB = b.first;
            while (currentB != null){
                if(currentA.data==currentB.data){
                    k = false;
                }
                currentB = currentB.next;
            }
            if(k){
                newDL.insertLast(currentA.data);
            }
            currentA = currentA.next;
        }
        //second step
        DoubleNode currentB = b.first;
        while (currentB!=null){
            newDL.insertLast(currentB.data);
            currentB = currentB.next;
        }
        return newDL;
    }

}
