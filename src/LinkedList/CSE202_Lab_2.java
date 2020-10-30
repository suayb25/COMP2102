package LinkedList;

public class CSE202_Lab_2 {
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.insertSorted(100);
        System.out.println(ml.toString());
        ml.insertSorted(112);
        System.out.println(ml.toString());
        ml.removeLast();
        System.out.println(ml.toString());
        ml.insertSorted(202);
        ml.insertSorted(302);
        System.out.println(ml.toString());
        ml.removeFirst();
        System.out.println(ml.toString());
        ml.insertSorted(750);
        System.out.println(ml.toString());
        ml.removeLast();
        System.out.println(ml.toString());
        System.out.println(ml.search(302));
        System.out.println("sum= " + ml.getSum());
        ml.removeLast();
        ml.removeLast();
        ml.insertFirst(100);
        ml.insertFirst(300);
        ml.insertAfter(ml.first, 500);
        System.out.println(ml.toString());
        System.out.println(ml.search(1000));
        ml.insertSorted(600);
        ml.insertSorted(25);
        System.out.println(ml.toString());
        System.out.println("Sum of all elements in LinkedList= " + ml.getSum());
        ml.insertNth(523,2);
        System.out.println(ml.toString());
        /*ml.insertAfterV2(112,272);
        System.out.println(ml.toString());*/
        System.out.println("-------------------");
        MyLinkedList[] a = new MyLinkedList[2];
        a[1] = ml;
        a[0] = ml;
        System.out.println("In array's first index, LinkedList first index data= "+a[0].first.data);
    }

}
