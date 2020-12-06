package AVLTree;

import java.util.NoSuchElementException;

public class AVLTreeComparable<Key extends Comparable<Key>, Value> {

    /**
     * The root node.
     */
    private AVLNodeComparable root;

    /**
     * Checks if the symbol table is empty.
     *
     * @return {@code true} if the symbol table is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Returns the largest key in the symbol table less than or equal to
     * {@code key}.
     *
     * @param key the key
     * @return the largest key in the symbol table less than or equal to
     *         {@code key}
     * @throws NoSuchElementException if the symbol table is empty
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to floor() is null");
        }
        if (isEmpty()){
            throw new NoSuchElementException("called floor() with empty symbol table");
        }
        AVLNodeComparable x = floor(root, key);
        if (x == null){
            return null;
        }
        else{
            return (Key) x.key;
        }
    }

    /**
     * Returns the node in the subtree with the largest key less than or equal
     * to the given key.
     *
     * @param x the subtree
     * @param key the key
     * @return the node in the subtree with the largest key less than or equal
     *         to the given key
     */
    private AVLNodeComparable floor(AVLNodeComparable x, Key key) {
        if (x == null){
            return null;
        }
        int cmp = key.compareTo((Key) x.key);
        if (cmp == 0){
            return x;
        }
        if (cmp < 0){
            return floor(x.left, key);
        }
        AVLNodeComparable y = floor(x.right, key);
        if (y != null){
            return y;
        }
        else{
            return x;
        }
    }
}
