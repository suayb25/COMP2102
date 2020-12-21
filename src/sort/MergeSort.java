package sort;

public class MergeSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        if (i == j) {
            return;
        }
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void mergeSort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    public static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        //System.out.println("lo= " + lo + " hi= " + hi);
        if (hi <= lo) {
            //System.out.println("return");
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(a, aux, lo, mid);
        //System.out.println("First merge finished");
        mergeSort(a, aux, mid + 1, hi);
        //System.out.println("merge");
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {//O(NlogN)
        System.out.println("lo= " + lo + " mid= " + mid + " hi= " + hi);
        System.arraycopy(a, 0, aux, 0, a.length);
        int j = lo;
        int k = mid + 1;

        for (int i = lo; i <= hi; i++) {
            if (j <= mid && k <= hi) {
                if (less(aux[j], aux[k])) {
                    a[i] = aux[j++];
                } else {
                    a[i] = aux[k++];
                }
            } else if (j <= mid) {
                a[i] = aux[j++];
            } else if (k <= hi) {
                a[i] = aux[k++];
            }
        }
    }

    public static void print(Comparable[] a) {
        System.out.println("Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {4, 7, 2, 67, 8, 2, 1, 0, -4};
        System.out.println("Testing insertion sort");
        print(a);
        mergeSort(a);
        print(a);

        Integer[] ascending = {4,7,9,67,100,101};
        print(ascending);
        mergeSort(ascending);
        print(ascending);
        Integer[] descending = {101,100,67,9,7,4};
        print(descending);
        mergeSort(descending);
        print(descending);
    }


}
