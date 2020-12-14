package AVLTree;

import java.util.TreeMap;

public class AVLTree_Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("----Test 1 Start------");
        AVLTree<String> test1 = new AVLTree<String>();
        test1.insert("1", 1);
        test1.insert("2", 2);
        test1.insert("3", 3);
        test1.insert("4", 4);
        test1.insert("5", 5);
        test1.insert("6", 6);
        test1.traverseLevelOrder(test1.root);
        System.out.println("-----Test 1 End---------");

        System.out.println("-----Test 2 Start-------");
        AVLTree<String> test2 = new AVLTree<String>();
        test2.insert("İlayda", 50);
        test2.insert("Boray", 25);
        test2.insert("Ahmet", 75);
        test2.insert("Mehmet", 10);
        test2.insert("Boray", 35);
        test2.insert("Ayşegül", 60);
        test2.insert("Kamil", 95);
        test2.insert("Enes", 5);
        test2.insert("Salih", 12);
        test2.traverseLevelOrder(test2.root);
        System.out.println("Floor(27) Recursive= " + test2.floorRecursive(test2.root, 27));
        System.out.println("Floor(27)= " + test2.floor(test2.root, 27));
        System.out.println("Floor(24)= " + test2.floor(test2.root, 24));
        System.out.println("Ceil(55)= " + test2.ceil(test2.root, 55));
        System.out.println("-----Test 2 End-------");

        TreeMap treeMap = new TreeMap();
        treeMap.put(5, "kdf");

    }
}
