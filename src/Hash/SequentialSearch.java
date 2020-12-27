package Hash;

import Queue.GenericLinkedQueue;

/**
 * LinkedList Key-Value version
 *
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearch<Key, Value> {
    private int N; //number of key-value pairs
    private Node<Key, Value> first;

    private class Node<Key, Value> {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.val = value;
            this.next = next;
        }

        public Node(Key key, Value value) {
            this.key = key;
            this.val = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public SequentialSearch() {
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void insert(Key key, Value val) {
        if (val == null) {
            return;
        }
        Node current = first;
        while (current != null) {
            if (key.equals(current.key)) {
                current.val = val;
                return;
            }
            current = current.next;
        }
        first = new Node<>(key, val, first);
        N++;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        for (Node<Key, Value> x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            N--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        GenericLinkedQueue<Key> queue = new GenericLinkedQueue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue((Key) x.key);
        return (Iterable<Key>) queue;
    }

    @Override
    public String toString() {
        return "SequentialSearch{" +
                "n=" + N +
                ", first=" + first +
                '}';
    }
}