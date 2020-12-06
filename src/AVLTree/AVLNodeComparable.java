package AVLTree;

public class AVLNodeComparable<Key extends Comparable<Key>,Value> {
    public final Key key;   // the key
    public Value val;       // the associated value
    public int height;      // height of the subtree
    public int size;        // number of nodes in subtree
    public AVLNodeComparable left;       // left subtree
    public AVLNodeComparable right;      // right subtree

    public AVLNodeComparable(Key key, Value val, int height, int size) {
        this.key = key;
        this.val = val;
        this.size = size;
        this.height = height;
    }
}
