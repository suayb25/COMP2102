package Hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class LinearProbingHash<Key> {
    int[] collision = new int[3000];
    Key[] table;
    int M;
    int N; // number of full elements
    boolean[] full;

    public LinearProbingHash(int M){
        table = (Key[]) new Object[M];
        full = new boolean[M];
        this.N=0;
        this.M = M;
    }

    public int hash(Key t){
        return ((t.hashCode()&0x7fffffff) % M);

    }

    public boolean insert(Key key){
        if (key == null){
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (N >= M/2){
            resize(2*M);
        }
        if(contains(key)){
            collision[hash(key)]++;
        }
        int i;
        int h = hash(key);
        System.out.println("hash("+ key + ")= "+h);
        for (i = h; table[i] != null; i = (i + 1) % M) {
            if (table[i].equals(key)) {
                return false;
            }
            /*if(i+1 == h){
                break;
            }*/
        }
        table[i] = key;
        N++; // increase number of stored items
        return true;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        System.out.println("resize");
        LinearProbingHash<Key> temp = new LinearProbingHash<Key>(capacity);
        for (int i = 0; i < M; i++) {
            if (table[i] != null) {
                temp.insert(table[i]);
            }
        }
        table = temp.table;
        full = temp.full;
        M    = temp.M;
    }

    public void delete(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)){
            return;
        }

        // find position i of key
        int i = hash(key);
        while (!key.equals(table[i])) {
            i = (i + 1) % M;
        }

        // delete key and associated value
        table[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % M;
        while (table[i] != null) { //maybe there was a collision so we need to rehash
            // delete keys[i] an vals[i] and reinsert
            Key keyToRehash = table[i];
            table[i] = null;
            N--;
            insert(keyToRehash);
            i = (i + 1) % M;
        }
        N--;
        // halves size of array if it's 12.5% full or less
        if (N > 0 && N <= M/8){
            resize(M/2);
        }
    }

    public boolean contains(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public Key get(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); table[i] != null; i = (i + 1) % M){
            if (table[i].equals(key)){
                return table[i];
            }
        }
        return null;
    }

    public int distinctCount(){
        int distinctCount=0;
        for (int k=0;k<table.length;k++){
            if(table[k]!=null){
                distinctCount++;
            }
        }
        return distinctCount;
    }
    public String toString(){
        String s = "[";
        for(int i = 0; i < M; i++){
            s+=table[i]+",";
        }
        return s+"]";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        LinearProbingHash<String> h2 = new LinearProbingHash<String>(691);
        String fname = "alice.txt";
        Scanner sc = null;
        try{
            // File is too long, we use a FileReader
            sc = new Scanner(new BufferedReader(new FileReader(fname)));


            int i = 0;
            while(sc.hasNext()){
                String s = sc.next();
                h2.insert(s);
                System.out.println((i++)+" ith word: "+s);

            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("Unable to read the file!"+e);
        }

        System.out.println(h2.toString());
        System.out.println("------Collisions--------");
        int maxCollisionIndex = 0;
        for(int k=0;k<h2.collision.length;k++){
            if(h2.collision[k]!=0){
                System.out.println("index= " + k + " count= " + h2.collision[k]);
                if(h2.collision[k]>maxCollisionIndex){
                    maxCollisionIndex=k;
                }
            }
        }
        System.out.println("Max Collision Index= " + maxCollisionIndex);
        System.out.println("N= "+h2.N);
        System.out.println("Distinct Count= " + h2.distinctCount());
        System.out.println(h2.toString());
        h2.delete("true.)");
        System.out.println(h2.toString());

    }
}
