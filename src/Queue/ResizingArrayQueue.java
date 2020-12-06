package Queue;

import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item extends Comparable<? super Item>>{
    private Item[] q; // array of elements
    int N = 0; // number of elements on queue private
    int first; // index of first element of queue
    int last; // index of next available slot

    public ResizingArrayQueue(int size) {
        q = (Item[]) new Comparable[size];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // Enqueue, put a new data to the last
    public void enqueue(Item data) {
        // double size of array if necessary and recopy to front of array
        if (N == q.length) {
            resize(2 * q.length);   // double size of array if necessary
        }
        q[last++] = data; // add data

        if (last == q.length) {
            last = 0;          // wrap-around
        }
        N++;
    }

    // Dequeue remove the first data
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item data = q[first];
        q[first] = null;
        N--;
        first++;
        if (first == q.length || q[first] == null) {
            first = 0;           // wrap-around
        }        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return data;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return q[first];
    }


    public Item getMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        Item max = q[0];
        if (max instanceof Integer) {
            for (int i = 0; i < N; i++) {
                int comp = q[i].compareTo(max);
                System.out.println("comp= "+comp);
                //0 means q[i] equals max
                //smaller than 0 means q[i] is less than max
                // smaller than 0 means q[i] is greater than max
                if (comp > 0) {
                    max = q[i];
                }
            }
            return max;
        } else {
            throw new IllegalArgumentException("getMax method is for Queue<Integer>");
        }
    }


    void putLast2First() {
        if (first == last) {
            return;
        }
        first--;
        if (first < 0) {
            first = last - 1;
            last = last - 2;
        } else {
            q[first] = q[last - 1];
            q[last - 1] = null;
            last--;
        }
        if (last < 0) {
            last = q.length - 1;
        }
        //System.out.println("");
    }

    public String printQueueOrder() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[i] + " ");
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[(first + i) % q.length] + " ");
        }
        return s;
    }

    public void resize(int newSize) {
        if (newSize <= N) {
            throw new IllegalArgumentException("Invalid price: " + newSize);
        }
        System.out.println("newSize= " + newSize);
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp.clone();
        first = 0;
        last = N;
    }
}
