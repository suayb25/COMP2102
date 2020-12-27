package bst;

import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<Item> {
    Node<Item> root;

    public BST() {
        root=null;
    }

    /**
     * adds a new Node to the tree
     */
    public void addNode(int key, Item nm) {
        // if the tree is empty
        if (root == null) {
            root = new Node(key, nm);
        } else {
            Node tmp = root;
            Node parent = root;
            while (tmp != null) {
                parent = tmp;
                if (key < tmp.key) {
                    tmp = tmp.left;
                } else if (key > tmp.key) {
                    tmp = tmp.right;
                }else{
                    parent.data = nm;
                    break;
                }
            }
            Node n = new Node(key, nm);
            if (key < parent.key) {
                parent.left = n;
            }else if(key > parent.key) {
                parent.right = n;
            }
        }
    }

    public Node search(int key) {
        return searchRecursive(this.root, key);
    }

    public Node searchRecursive(Node focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.key == key) //found return the node
        {
            return focus;
        } else if (key < focus.key){ //check which side to go
            return searchRecursive(focus.left, key);
        } else {
            return searchRecursive(focus.right, key);
        }
    }

    /**
     * right most node
     * @param focus
     * @return
     */
    public Node maxSearch(Node focus) {
        if (focus.right == null) {
            return focus;
        } else {
            return maxSearch(focus.right);
        }
    }

    /**
     * find the min, left most node
     * @param focus
     * @return
     */
    public Node minSearch(Node focus) {
        if (focus.left == null) {
            return focus;
        } else {
            return minSearch(focus.left);
        }
    }

    public void traverseInOrder(Node focus) {
        if (focus.left != null) {
            traverseInOrder(focus.left);
        }
        System.out.println(focus);
        if (focus.right != null) {
            traverseInOrder(focus.right);
        }
    }

    public void traversePreOrder(Node focus) {

        System.out.println(focus);
        if (focus.left != null) {
            traversePreOrder(focus.left);
        }
        if (focus.right != null) {
            traversePreOrder(focus.right);
        }
    }

    public void traverseLevelOrder(Node focus) {
        java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();
        que.add(focus);
        while (!que.isEmpty()) {
            Node d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    public int countGreaterThanRoot() {
        int count = 0;
        if (root.right != null) {
            java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();
            que.add(root.right);
            count++;
            while (!que.isEmpty()) {
                Node d = que.removeFirst();
                if (d.left != null) {
                    que.addLast(d.left);
                    count++;
                }
                if (d.right != null) {
                    que.addLast(d.right);
                    count++;
                }
                System.out.println(d);
            }
            return count;
        } else {
            throw new NoSuchElementException();
        }
    }

    // method calculates number of nodes in the tree
    public int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            int a = size(n.left) + 1;
            int b = size(n.right);
            return (a + b);
        }
    }

    public int mymet(Node node) { //Do we need to start from root
        if (node == null) {
            return 0;
        } else {
            return (int) node.data - (mymet(node.left) + mymet(node.right)) / 2;
        }
    }

    public int sum() {
        int sum = 0;
        if (root != null) {
            java.util.LinkedList<Node> que = new java.util.LinkedList<Node>();
            que.add(root);
            sum += root.key;
            while (!que.isEmpty()) {
                Node d = que.removeFirst();
                if (d.left != null) {
                    que.addLast(d.left);
                    sum += d.left.key;
                }
                if (d.right != null) {
                    que.addLast(d.right);
                    sum += d.right.key;
                }
                //System.out.println(d);
            }
            return sum;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int maxDepth(Node x){
        if(x==null){
            return -1;
        }
        return 1 + Math.max(maxDepth(x.left),maxDepth(x.right));
    }

    public Node delete(Node focus,int key) {
        if (focus == null){
            return null;
        }
        if (key < focus.key){
            focus.left  = delete(focus.left,  key);
        } else if (key > focus.key){
            focus.right = delete(focus.right, key);
        }else {
            if (focus.right == null){
                return focus.left;
            }
            if (focus.left  == null){
                return focus.right;
            }
            Node t = focus;
            focus = min(t.right);  //make the smallest node of the right side as root of that subtree
            focus.right = deleteMin(t.right); //Actually deleteMin() returning a subtree look at code carefully
            focus.left = t.left;
        }
        return focus;
    }

    public Node max(Node x) {
        if(root==null) {
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.right == null){
            return x;
        }
        else{
            return max(x.right);
        }
    }

    public Node min(Node x) {
        if(root==null) {
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x;
        }
        else {
            return min(x.left);
        }
    }

    /**
     * It deletes the min node and returns the sent root/x node
     * @param x
     * @return
     */
    public Node deleteMin(Node x) {
        if (root==null){
            throw new NoSuchElementException("BST is empty!");
        }
        if (x.left == null){
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

    /**
     * It converts tree to its mirror
     * If you want to reconvert call mirror again
     * @param node
     */
    public void mirror(Node node) {
        if(node == null) {
            return;
        }
        mirror(node.left);
        mirror(node.right);

        Node temp;
        temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * Method checks whether subtree is a BST
     * @param focus (Node)
     * @return
     */
    public boolean isBST1(Node focus) {
        if (focus == null) {
            return true;
        }

        if (focus.left != null && maxSearch(focus.left).key > focus.key) {
            return false;
        }
        if (focus.right != null && minSearch(focus.right).key <= focus.key) {
            return false;
        }

        if (!isBST1(focus.left) || !isBST1(focus.right)) { //each sub tree(left and right) we need to call it again
            return false;
        }
        return true;
    }

    /**
     * Calculates each leaf node's path length
     * @param node
     * @param count
     */
    public void pathLengths(Node node, int count){
        System.out.println("count= "+count);
        if(node.left == null && node.right == null){
            System.out.println("Leaf reached: "+node+" Path: "+ count);
        }
        else{
            if(node.left != null){
                pathLengths(node.left, ++count);
                count--;  // Because we are going to one level up.
                //If there is no left, we will not enter left. If we enter, we have to decrease the count as we increase it.
            }
            if(node.right != null){
                pathLengths(node.right, ++count);
            }
            count--; //We have to decrease count when we turn up, whether there is right or not.
        }
    }

    /**
     * Clone nodes under the whole BST's root.
     * @return
     */
    public BST<Item> clone() {
        BST<Item> cloneBST = new BST<>();
        cloneBST.root = cloneSubTree(this.root);
        return cloneBST;
    }

    /**
     * Clone nodes under a specific root.
     * @param focus
     * @return
     */
    public Node<Item> cloneSubTree(Node<Item> focus) {
        if (focus == null) {
            return null;
        } else {
            Node<Item> t = new Node<>(focus.key, focus.data);//each time we need to create a node.
            t.left = cloneSubTree(focus.left);
            t.right = cloneSubTree(focus.right);
            return t;
        }
    }

    public static void main(String[] args) {
        BST<Integer> binarySearchTreeInteger2 = new BST<Integer>();
        binarySearchTreeInteger2.addNode(84,84);
        binarySearchTreeInteger2.addNode(22,22);
        binarySearchTreeInteger2.addNode(65,65);
        binarySearchTreeInteger2.addNode(34,34);
        binarySearchTreeInteger2.addNode(76,76);
        binarySearchTreeInteger2.addNode(31,31);
        binarySearchTreeInteger2.addNode(49,49);
        binarySearchTreeInteger2.addNode(66,66);
        binarySearchTreeInteger2.addNode(33,33);
        binarySearchTreeInteger2.traverseLevelOrder(binarySearchTreeInteger2.root);
        System.out.println("-------");
    }
}
