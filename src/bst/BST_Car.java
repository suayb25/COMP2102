package bst;

public class BST_Car {

    Car root;

    /**
     * adds a new Node to the tree
     */
    public void addNode(int plateNo, int engineSize,String owner) {
        Car n = new Car(plateNo, engineSize,owner);
        // if the tree is empty
        if (root == null) {
            root = n;
        } else {
            Car tmp = root;
            Car parent = root;
            while (tmp != null) {
                parent = tmp;
                if (plateNo < tmp.plateNo) {
                    tmp = tmp.left;
                } else if (plateNo > tmp.plateNo) {
                    tmp = tmp.right;
                }
            }
            if (plateNo < parent.plateNo) {
                parent.left = n;
            } else {
                parent.right = n;
            }
        }
    }

    public Car search(int key) {
        return searchRecursive(this.root, key);
    }

    public Car searchRecursive(Car focus, int key) {
        if (focus == null) {
            return null;
        }
        if (focus.plateNo == key) //found return the node
        {
            return focus;
        } else if (key < focus.plateNo) //check which side to go
        {
            return searchRecursive(focus.left, key);
        } else //
        {
            return searchRecursive(focus.right, key);
        }
    }

    // right most node
    public Car maxSearch(Car focus) {
        if (focus.right == null) {
            return focus;
        } else {
            return maxSearch(focus.right);
        }
    }

    // find the min, left node
    public Car minSearch(Car focus) {
        if (focus.left == null) {
            return focus;
        } else {
            return minSearch(focus.left);
        }
    }

    public void traversePreOrder(Car focus) {

        System.out.println(focus);
        if (focus.left != null) {
            traversePreOrder(focus.left);
        }
        if (focus.right != null) {
            traversePreOrder(focus.right);
        }
    }

    public void traverseLevelOrder(Car focus) {
        java.util.LinkedList<Car> que = new java.util.LinkedList<Car>();
        que.add(focus);
        while (!que.isEmpty()) {
            Car d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    // method calculates number of nodes in the tree
    public int size(Car n) {
        if (n == null) {
            return 0;
        } else {
            int a = size(n.left) + 1;
            int b = size(n.right);
            return (a + b);
        }
    }

    // method checks whether subtree is a BST
    public boolean isBST1(Car focus) {
        if (focus == null) {
            return (true);
        }
        // do the subtrees contain values that do not
        // agree with the node?
        if (focus.left != null && maxSearch(focus.left).plateNo > focus.plateNo) {
            return (false);
        }
        if (focus.right != null && minSearch(focus.right).plateNo <= focus.plateNo) {
            return (false);
        }

        if (!isBST1(focus.left) || !isBST1(focus.right)) {
            return (false);
        }

        return true;

    }
}
