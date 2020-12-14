package Hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class LinearProbingDoubleHash<Key> {
    //int[] collision = new int[10000];
    Key[] table;
    int M;
    int primeSize;
    int N; // number of full elements
    boolean[] full;

    public LinearProbingDoubleHash(int M){
        table = (Key[]) new Object[M];
        full = new boolean[M];
        this.N=0;
        this.M = M;
        primeSize=getPrime();
    }

    public int hash(Key t){
        return ((t.hashCode()&0x7fffffff) % M);

    }

    public int hash2(Key t){
        return (primeSize- ((t.hashCode()&0x7fffffff) % primeSize));

    }

    public boolean insert(Key key){
        if (key == null){
            throw new IllegalArgumentException("first argument to put() is null");
        }
        if (N >= M/2){
            resize(2*M);
        }
        int i = hash(key);
        if(table[i] != null){
            int h = hash2(key);
            int k = 1;
            while (true) {
                // get newIndex
                int newIndex = (i + k * h) % M;
                // if no collision occurs, break
                if (table[newIndex]==null) {
                    table[newIndex] =  key;
                    break;
                }
                k++;
            }
        }else{
            table[i] = key;
        }
        N++; // increase number of stored items
        return true;
    }

    public int getPrime()
    {
        for (int i = M - 1; i >= 1; i--) {
            int divisionCount = 0;
            for (int j = 2; j <= (int) i/2; j++)
                if (i % j == 0){
                    divisionCount++;
                }
            if (divisionCount == 0){
                return i;
            }
        }
        return 3;
    }

    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void resize(int capacity) {
        System.out.println("resize");
        LinearProbingDoubleHash<Key> temp = new LinearProbingDoubleHash<Key>(capacity);
        System.out.println("temp.table.length= " + temp.table.length);
        for (int i = 0; i < M; i++) {
            if (table[i] != null) {
                temp.insert(table[i]);
            }
        }
        table = temp.table;
        full = temp.full;
        M    = temp.M;
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
    public String toString(){
        String s = "[";
        for(int i = 0; i < M; i++){
            s+=table[i]+",";
        }
        return s+"]";
    }

    public static void main(String[] args) {

        LinearProbingDoubleHash<String> h2 = new LinearProbingDoubleHash<String>(691);
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
            System.out.println("Unable to read the file!" + e);
        }
        System.out.println(h2.toString());
    }
}
