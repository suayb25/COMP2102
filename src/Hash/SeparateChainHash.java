package Hash;

public class SeparateChainHash<Item> {
    private static final int INIT_CAPACITY = 4;
    int M; //capacity
    LinkedList<Item>[] table;

    /*public SeparateChainHash() {
        this(INIT_CAPACITY);
    }*/

    public SeparateChainHash(int M) {
        table = new LinkedList[M];
        this.M = M;
        for (int i = 0; i < M; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int hash(Item key) {
        return ((key.hashCode() & 0x7ffffff) % M);
    }

    public void insert(Item key) {
        int i = hash(key);

        table[i].insert(key); //linkedList checks the key. If this key is in LinkedList, it will just update it.
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < M; i++) {
            if (table[i] != null) {
                s += i + "th" + table[i].toString() + "\n";
            }
        }
        return s;
    }

    public boolean contains(Item key) {
        if (key == null) {
            throw new IllegalArgumentException("");
        }
        return get(key) != null;
    }

    public Item get(Item key) {
        if (key == null) {
            throw new IllegalArgumentException("");
        }
        int i = hash(key);
        return table[i].get(key);
    }

    public double loadFactor() { //average number of items stored in the LinkedList
        double countNumberItem = 0;
        for(int i = 0; i<table.length;i++){
            countNumberItem += table[i].size;
        }
        return (countNumberItem/table.length)/1.0; //countNumberItem/M;
    }

    public void delete(Item key){
        if (key == null) {
            throw new IllegalArgumentException("");
        }
        int i = hash(key);
        if(table[i].get(key)!=null){
            M--;
        }
        table[i].delete(key);
    }

    public static void main(String[] args) {
        SeparateChainHash<String> stringSeparateChainHash = new SeparateChainHash<>(10);
        stringSeparateChainHash.insert("cse");
        stringSeparateChainHash.insert("cse");
        stringSeparateChainHash.insert("comp");
        System.out.println(stringSeparateChainHash.toString());
        System.out.println(stringSeparateChainHash.loadFactor());
        System.out.println("----Delete-----");
        stringSeparateChainHash.delete("cse");
        System.out.println(stringSeparateChainHash.toString());
        System.out.println("-------------");
        SeparateChainHash<Integer> stringSeparateChainQuiz = new SeparateChainHash<>(6);
        stringSeparateChainQuiz.insert(7);
        stringSeparateChainQuiz.insert(3);
        stringSeparateChainQuiz.insert(11);
        stringSeparateChainQuiz.insert(12);
        stringSeparateChainQuiz.insert(15);
        stringSeparateChainQuiz.insert(11);
        stringSeparateChainQuiz.insert(16);
        System.out.println(stringSeparateChainQuiz.toString());
    }
}