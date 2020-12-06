package Stack;

import java.util.NoSuchElementException;

public class GenericStack<Item> {
    private Item[] a;    // holds the items
    public int N;       // number of items in stack

    // create an empty stack with given capacity
    public GenericStack(int capacity) {
        a = (Item[]) new Object[capacity];   // no generic array creation
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == a.length;
    }

    public void push(Item item) {
        if (item == null) {
            throw new NoSuchElementException();
        }
        if (!isFull()) {
            a[N++] = item;
        } else {
            throw new IllegalStateException();
        }
    }

    public Item pop() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int deletedIndex = N - 1;
        Item temp = a[deletedIndex];
        a[deletedIndex] = null;
        N--;
        System.out.println("");
        return temp;
    }

    public Item[] getItems() {
        return this.a;
    }

    public void swapTopMostTwo() {
        if(isEmpty() || N==1){
            return;
        }
        Item temp = a[N-1];
        a[N-1]=a[N-2];
        a[N-2]=temp;
    }

    public Item popBottom() {
        if(isEmpty()){
            throw new java.util.NoSuchElementException();
        }
        Item temp = a[0];
        a[0]=null;
        for(int i = 1; i<N; i++){
            a[i-1]=a[i];
        }
        a[N-1]=null;
        N--;
        return temp;
    }

    public int productPopBottom() {
        if (isEmpty() || N == 1) {
            throw new java.util.NoSuchElementException();
        }
        Item temp1 = a[0];
        Item temp2 = a[1];
        a[0] = null;
        a[1] = null;
        for (int i = 2; i < N; i++) {
            a[i - 2] = a[i];
        }
        a[N - 1] = null;
        a[N - 2] = null;
        N = N - 2;
        return (Integer) temp1 * (Integer) temp2;
    }
}
