package DoubleLinkedList;

public class CSE202_Lab_3 {

    public static void main(String[] args) {
        MyDoubleLinkedList dl = new MyDoubleLinkedList();
        dl.insertFirst(110);
        dl.insertFirst(250);
        dl.insertFirst(500);
        dl.insertFirst(750);
        dl.insertFirst(650);

        System.out.print("dl = ");dl.print();
        System.out.println("\n-------------Swap-------------------");
        dl.swap(dl.first.next,dl.last.previous);
        System.out.print("dl = ");dl.print();
        System.out.println();
        System.out.println("\n-------------Insert Middle-------------------");
        dl.insertMiddle(272);
        System.out.print("dl = ");dl.print();
        System.out.println("\n-----------Concat---------------------");
        MyDoubleLinkedList dl2 = new MyDoubleLinkedList();
        dl2.insertFirst(55);
        dl2.insertFirst(90);
        dl2.insertFirst(785);
        dl2.insertFirst(650);
        MyDoubleLinkedList newDL=dl.concat(dl,dl2);
        System.out.print("dl = ");dl.print();
        System.out.print("dl2 = ");dl2.print();
        System.out.print("newDL = ");newDL.print();


        System.out.println("\n-----------Union--------------------");
        dl2.insertLast(500);
        System.out.print("dl = " );dl.print();
        System.out.print("dl2 = ");dl2.print();
        MyDoubleLinkedList newDL2=dl.union(dl,dl2);
        System.out.print("newDL2 = " );newDL2.print();
        System.out.print("dl = " );dl.print();

        System.out.println("\n-----------------------------------");
        int[] array1=new int[2];
        array1[0]=5;

        System.out.println(array1);
        int[] array2=new int[2];
        System.out.println(array2);
        array2 = array1;
        System.out.println(array2);
        array2[0]=3;
        System.out.println(array1[0]);
    }
}
