package AVLTree;

public class AVLNode<Item> {
    public int key;
    public Item data;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(Item data, int key) {
        this.key = key;
        this.data = data;
        left = null;
        right = null;
        height = 0;
    }

    @Override
    public String toString() {
        return "AVLNode{" + "key=" + key + ", data=" + data.toString() + '}';
    }
}
