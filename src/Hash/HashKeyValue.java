package Hash;

import java.util.Arrays;

/**
 * Same as import java.util.HashMap;
 * @param <Key>
 * @param <Value>
 */
public class HashKeyValue<Key,Value> {
    private static final int INIT_CAPACITY = 4;
    int N;
    int M;
    private SequentialSearch<Key, Value>[] table;

    public HashKeyValue(int M) {
        this.M = M;
        table = (SequentialSearch<Key, Value>[]) new SequentialSearch[M];
        for (int i = 0; i < M; i++) {
            table[i] = new SequentialSearch<Key, Value>();
        }
    }

    public int hash(Key key){
        return ((key.hashCode() & 0x7ffffff) % M);
    }

    private void resize(int chains) {
        HashKeyValue<Key, Value> temp = new HashKeyValue<Key, Value>(chains);
        for (int i = 0; i < M; i++) {
            for (Key key : table[i].keys()) {
                temp.insert(key, table[i].get(key));
            }
        }
        this.M  = temp.M;
        this.N  = temp.N;
        this.table = temp.table;
    }

    public void insert(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }
        // double table size if average length of list >= 10
        if (N >= 10*M) resize(2*M);

        int i = hash(key);
        if (!table[i].contains(key)){
            N++;
        }
        table[i].insert(key, val);
    }

    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (table[i].contains(key)){
            N--;
        }
        table[i].delete(key);
        // halve table size if average length of list <= 2
        if (M > INIT_CAPACITY && N <= 2*M){
            resize(M/2);
        }
    }

    @Override
    public String toString() {
        return "HashKeyValue{" +
                "N=" + N +
                ", M=" + M +
                ", table=" + Arrays.toString(table) +
                '}';
    }

    public static void main(String[] args) {
        HashKeyValue<String,Integer> hashKeyValue = new HashKeyValue<String, Integer>(10);
        hashKeyValue.insert("cse",5);
        hashKeyValue.insert("Cse",5);
        for(int i=0;i<hashKeyValue.M;i++){
            System.out.println(hashKeyValue.table[i].toString());
        }
    }
}
