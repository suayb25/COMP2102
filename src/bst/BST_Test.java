package bst;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

public class BST_Test<Item> {

    public static void main(String[] args) throws IOException {
        BST<String> binarySearchTree = new BST<String>();

        /*binarySearchTree.addNode(50, "sena");
        binarySearchTree.addNode(25, "ali");
        binarySearchTree.addNode(75, "timur");
        binarySearchTree.addNode(90, "cem");
        binarySearchTree.addNode(10, "ebru");
        binarySearchTree.addNode(30, "vahdet");
        binarySearchTree.addNode(26, "canset");*/

        BST<Integer> binarySearchTreeInteger = new BST<Integer>();
        binarySearchTreeInteger.addNode(4,4);
        binarySearchTreeInteger.addNode(3,3);
        binarySearchTreeInteger.addNode(1,1);
        binarySearchTreeInteger.addNode(0,0);
        binarySearchTreeInteger.addNode(2,2);
        binarySearchTreeInteger.addNode(15,15);
        binarySearchTreeInteger.addNode(18,18);
        binarySearchTreeInteger.addNode(17,17);
        binarySearchTreeInteger.addNode(31,31);

        System.out.println("mymet result= "+binarySearchTreeInteger.mymet(binarySearchTreeInteger.root));
        System.out.println("------------------------");
        BST<Integer> binarySearchTreeInteger2 = new BST<Integer>();
        binarySearchTreeInteger2.addNode(30,30);
        binarySearchTreeInteger2.addNode(10,10);
        binarySearchTreeInteger2.addNode(5,5);
        binarySearchTreeInteger2.addNode(2,2);
        binarySearchTreeInteger2.addNode(12,12);
        binarySearchTreeInteger2.addNode(50,50);
        binarySearchTreeInteger2.addNode(34,34);
        binarySearchTreeInteger2.addNode(65,65);
        binarySearchTreeInteger2.addNode(45,45);
        System.out.println("-------Traverse Level-Order---------");
        binarySearchTreeInteger2.traverseLevelOrder(binarySearchTreeInteger2.root);

        binarySearchTreeInteger2.pathLengths(binarySearchTreeInteger2.root,0);

        BST<Integer> cloneBST = binarySearchTreeInteger2.clone();

        //System.out.println("---------******-----------");
        //binarySearchTreeInteger2.traverseLevelOrder2(binarySearchTreeInteger2.root);
        //System.out.println("--------*****------------");
        binarySearchTreeInteger2.delete(binarySearchTreeInteger2.root,50);//delete operation

        System.out.println("Greater Than Root Count = " + binarySearchTreeInteger2.countGreaterThanRoot());

        System.out.println("\nSum= " + binarySearchTreeInteger2.sum());
        System.out.println("-------Traverse Pre-Order---------");
        binarySearchTreeInteger2.traversePreOrder(binarySearchTreeInteger2.root);

        binarySearchTreeInteger2.mirror(binarySearchTreeInteger2.root); //mirror tree
        System.out.println("\n------Mirror Result----------");
        binarySearchTreeInteger2.traversePreOrder(binarySearchTreeInteger2.root);

        binarySearchTreeInteger2.mirror(binarySearchTreeInteger2.root); //re mirror for other operations
        System.out.println("\n------Re-Mirror Result--------");
        binarySearchTreeInteger2.traversePreOrder(binarySearchTreeInteger2.root);

        /*System.out.println("MaxDepth= " + binarySearchTreeInteger2.maxDepth(binarySearchTreeInteger2.root));*/

        System.out.println("-----------------------------");
        BST_Car binarySearchTreeCar = new BST_Car();
        binarySearchTreeCar.addNode(25,120,"Suayb");
        binarySearchTreeCar.addNode(65,128,"Boray");
        binarySearchTreeCar.addNode(54,160,"Elif");
        binarySearchTreeCar.addNode(85,158,"İlayda");
        binarySearchTreeCar.addNode(94,110,"Enes");
        binarySearchTreeCar.addNode(20,105,"Merve");
        System.out.println(binarySearchTreeCar.search(25));


        TreeMap treeMap = new TreeMap();
        treeMap.put("Ece",1204);
        treeMap.put("cse",2020);
        System.out.println("Tree Map = "+treeMap.containsKey("Ece"));


        System.out.println("-------------------------");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        //If user enter year,month and date you can set in the LocalDateTime.of
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime date = LocalDateTime.of(2020,11,15,0,0);
        String formattedDate = date.format(myFormatObj);
        System.out.println("After Formatting: " + formattedDate);

        PrintWriter pw = new PrintWriter("deneme.txt");

        // pass the path to the file as a parameter
        FileReader fr = new FileReader("C:\\Users\\talha\\Desktop\\sdssds.txt");
        try {
            File myObj = new File("C:\\Users\\talha\\Desktop\\sdssds.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                //System.out.println("next= "+myReader.next());
                String data = myReader.nextLine();
                System.out.println("Each Line= "+data);

                pw.printf(data);

                String [] stringArray = data.split(",");
                for(int k = 0;k<stringArray.length;k++){
                    System.out.println(stringArray[k]);
                }
                int day = Integer.parseInt(stringArray[0].substring(0,2));
                int month = Integer.parseInt(stringArray[0].substring(3,5));
                int year = Integer.parseInt(stringArray[0].substring(6,10));
                System.out.println("day= "+day);
                System.out.println("month= "+month);
                System.out.println("year= "+year);
                LocalDateTime date1 = LocalDateTime.of(year,month,day,0,0);
                System.out.println("Created date from text= : " + date1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //File myObj = new File("project2.txt");
        pw.close();
        //06-05-2006,10.35,Ankara,Istanbul,THY,235TL
    }
}
