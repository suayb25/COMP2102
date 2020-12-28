package sort;

import java.util.Random;

public class QuickSort {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testQuickSort();
    }

    // abstraction of  less than <
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // swap
    private static void swap(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void swapInt(int[] a, int i, int j) {
        if (i == j) {
            return;
        }
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void print(Comparable[] ar) {
        System.out.print("Array: ");
        for (Comparable e : ar) {
            System.out.print(e.toString() + ", ");
        }
        System.out.println(".");
    }

    public static void printInt(int[] ar) {
        System.out.print("Array: ");
        for (int e : ar) {
            System.out.print(e + ", ");
        }
        System.out.println("..");
    }

    public static void testQuickSort() {
        Integer[] a2 = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing Quick Sort Comparable");
        print(a2);
        sort(a2);
        print(a2);

        int[] a3 = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing Quick Sort Int");
        printInt(a3);
        sortInt(a3);
        printInt(a3);

        int[] a4 = {1, 4, 67, 88, 102, 400};
        System.out.println("Testing Quick Sort Int");
        printInt(a4);
        sortInt(a4);
        printInt(a4);
    }

    public static void sort(Comparable[] a) {
        // shuffle /
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sortInt(int[] a) {
        // shuffle /
        shuffleInt(a);
        sortInt(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi); // partition and get pivot
        sort(a, lo, j - 1); // sort level of pivot j
        sort(a, j + 1, hi); // sort right of pivot j
    }

    private static void sortInt(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partitionInt(a, lo, hi); // partition and get pivot
        sortInt(a, lo, j - 1); // sort level of pivot j
        sortInt(a, j + 1, hi); // sort right of pivot j
    }

    public static void shuffle(Comparable[] a) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            //int randomIndex = (rnd.nextInt(a.length)+i)%a.length;
            int randomIndex = (rnd.nextInt(a.length-i)+i);
            swap(a,randomIndex,i);
            /*Comparable tmp = a[randomIndex];
            a[randomIndex] = a[i];
            a[i] = tmp;*/
        }
    }

    public static void shuffleInt(int[] a) {
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            //int randomIndex = (rnd.nextInt(a.length)+i)%a.length;
            int randomIndex = (rnd.nextInt(a.length-i)+i);
            swapInt(a,randomIndex,i);
            /*int tmp = a[randomIndex];
            a[randomIndex] = a[i];
            a[i] = tmp;*/
        }
    }

    private static int partitionInt(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int piv = a[lo];

        while (true) {
            while (a[++i] < piv) {
                if (i == hi) break;
            }
            while (a[--j] > piv) {
                if (i == lo) break;
            }
            if (i >= j) {
                break;
            }
            swapInt(a, i, j);
            System.out.print("Inner Swap:" + i + ", " + j + " ");
            printInt(a);
        }
        swapInt(a, lo, j);
        System.out.print("Outer Swap:" + lo + ", " + j + " ");
        printInt(a);
        return j;
    }


    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable piv = a[lo];

        // idea of this loop is that it starts to
        // search from left for greater item
        // from right a smaller item
        // swaps them
        // when pointers cross. it places pivot in between
        while (true) {
            while (less(a[++i], piv))
                if (i == hi) break;
            while (less(piv, a[--j]))
                if (i == lo) break;
            if (i >= j) // i crosses j
                break;
            swap(a, i, j);
            System.out.print("Inner Swap:" + i + ", " + j + " ");
            print(a);
        }
        swap(a, lo, j);
        System.out.print("Outer Swap:" + lo + ", " + j + " ");
        print(a);
        return j;
    }
}
