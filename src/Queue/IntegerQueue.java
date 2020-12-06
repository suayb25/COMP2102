package Queue;

import java.util.NoSuchElementException;

public class IntegerQueue {
    private int q[];
    int N = 0; // number of elements on queue private
    int first; // index of first element of queue
    int last;

    public IntegerQueue(int size) {
        q = new int[size];
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(int data) {
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

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        int data = q[first];
        System.out.println("first= " + first);
        q[first] = -1; //null
        N--;
        first++;
        if (first == q.length) {
            first = 0;           // wrap-around
        }        // shrink size of array if necessary
        if (N > 0 && N == q.length / 4) {
            resize(q.length / 2);
        }
        return data;
    }

    public void resize(int newSize) {
        if (newSize <= N) {
            throw new IllegalArgumentException("Invalid price: " + newSize);
        }
        System.out.println("newSize= " + newSize);
        @SuppressWarnings("unchecked")
        int[] temp = new int[newSize];
        for (int i = 0; i < N; i++) {
            temp[i] = q[(first + i) % q.length];
        }
        q = temp.clone();
        first = 0;
        last = N;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return q[first];
    }

    public String printQueueOrder() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[i] + " ");
        }
        return s;
    }

    public IntegerQueue mergeQueue(IntegerQueue q1, IntegerQueue q2) {
        IntegerQueue newQueue = new IntegerQueue(q1.N + q2.N);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int q1Value = q1.peek();
            int q2Value = q2.peek();
            if (q1Value < q2Value) {
                newQueue.enqueue(q1.dequeue());
            } else {
                newQueue.enqueue(q2.dequeue());
            }
        }
        while (!q1.isEmpty()) {
            newQueue.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            newQueue.enqueue(q2.dequeue());
        }
        return newQueue;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < q.length; i++) {
            s += (q[(first + i) % q.length] + " ");
        }
        return s;
    }

}
