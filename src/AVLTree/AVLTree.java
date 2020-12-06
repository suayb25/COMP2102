package AVLTree;

import bst.Node;

public class AVLTree<Item> {
    public AVLNode<Item> root;

    public AVLTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height(AVLNode focus) {
        if (focus == null) {
            return -1;
        } else {
            return focus.height;
        }
    }

    public AVLNode<Item> rotateRight(AVLNode focus) {//rotateMyLeft
        AVLNode<Item> temp = focus.left;
        focus.left = temp.right; // temp.right = focus.left.right
        temp.right = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }

    public AVLNode<Item> rotateLeft(AVLNode focus) {//rotateMyRight
        AVLNode<Item> temp = focus.right;
        focus.right = temp.left;
        temp.left = focus;
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        temp.height = Math.max(height(temp.left), height(temp.right)) + 1;
        return temp;
    }

    public void insert(Item data, int key) {
        root = insert(root, data, key);
    }

    public AVLNode<Item> insert(AVLNode focus, Item data, int key) {
        if (focus == null) {
            focus = new AVLNode(data, key);
        } else if (key < focus.key) {
            focus.left = insert(focus.left, data, key);
        } else if (key > focus.key) {
            focus.right = insert(focus.right, data, key);
        } else {
            focus.data = data;
        }
        focus.height = Math.max(height(focus.left), height(focus.right)) + 1;
        return balance(focus);//we will write it.
    }

    private int getBalance(AVLNode<Item> focus) {
        if (focus == null) {
            return 0;
        }
        return height(focus.left) - height(focus.right);
    }

    private AVLNode<Item> balance(AVLNode<Item> focus) {
        if (getBalance(focus) < -1) {
            if (getBalance(focus.right) > 0) {
                focus.right = rotateRight(focus.right);
            }
            focus = rotateLeft(focus);
        } else if (getBalance(focus) > 1) {
            if (getBalance(focus.left) < 0) {
                focus.left = rotateLeft(focus.left);
            }
            focus = rotateRight(focus);
        }
        return focus;
    }

    public void traverseLevelOrder(AVLNode focus) {
        java.util.LinkedList<AVLNode> que = new java.util.LinkedList<AVLNode>();
        que.add(focus);
        while (!que.isEmpty()) {
            AVLNode d = que.removeFirst();
            if (d.left != null) {
                que.addLast(d.left);
            }
            if (d.right != null) {
                que.addLast(d.right);
            }
            System.out.println(d);
        }
    }

    public int floor(AVLNode focus, int key) {
        AVLNode temp = focus;
        int minDifferences = key - focus.key;
        int minKey = focus.key;
        while (temp != null) {
            if (temp.key == key) {
                return key;
            } else {
                int newDifferences = key - temp.key;
                if (newDifferences >= 0 && newDifferences < Math.abs(minDifferences)) {
                    minDifferences = newDifferences;
                    minKey = temp.key;
                }
                if (key < temp.key) {
                    temp = temp.left;
                } else if (key > temp.key) {
                    temp = temp.right;
                }
            }
        }
        if (minDifferences >= 0) {
            return minKey;
        } else {
            return -1;
        }
    }

    public int floorRecursive(AVLNode focus, int key) {
        if (focus == null) {
            return -1;
        }
        if (key == focus.key) {
            return focus.key;
        }
        if (key < focus.key) {
            return floorRecursive(focus.left, key);
        }

        int x = floorRecursive(focus.right, key);

        if (x != -1) {
            return x;
        } else {
            return focus.key;
        }
    }

    public int ceil(AVLNode focus, int key) {
        if (focus == null) {
            return -1;
        }
        if (key == focus.key) {
            return focus.key;
        }
        if (key > focus.key) {
            return ceil(focus.right, key);
        }
        int x = ceil(focus.left, key);

        if (x != -1) {
            return x;
        } else {
            return focus.key;
        }
    }
}