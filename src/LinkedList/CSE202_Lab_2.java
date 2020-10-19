package LinkedList;

public class CSE202_Lab_2 {
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.insertSorted(100);
        ml.insertSorted(112);

        ml.removeLast();
        ml.insertSorted(202);
        System.out.println(ml.toString());
        ml.removeFirst();
        System.out.println(ml.toString());
        ml.insertSorted(150);
        System.out.println(ml.toString());
        ml.removeLast();
        System.out.println(ml.toString());
        System.out.println(ml.search(650));
        System.out.println("sum= " + ml.getSum());

        ml.insertAfter(ml.first, 500);
        System.out.println(ml.toString());
        System.out.println(ml.search(500));
        ml.insertSorted(600);
        ml.insertSorted(25);
        System.out.println(ml.toString());
        System.out.println("Sum of all elements in LinkedList= " + ml.getSum());

        /*ml.insertAfterV2(112,272);
        System.out.println(ml.toString());*/

        MyLinkedList[] a = new MyLinkedList[2];
        a[1] = ml;
        a[0] = ml;
        System.out.println("In array's first index, LinkedList first index data= "+a[0].first.data);
    }

}
