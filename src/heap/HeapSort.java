package heap;

public class HeapSort {

    public static void sort(int[] arIn) {
        int N = arIn.length;
        //heapify
        for (int k = N / 2; k >= 1; k--) {
            sink(arIn,k,N);
        }
        System.out.println("Heapified: ");
        print(arIn);
        for(int k = arIn.length; k>1;){
            swap(arIn,1,k--);
            sink(arIn,1,k);
        }
    }

    public static void sink(int[] ar, int k, int h) {
        while ((2 * k) <= h) {
            int mx = 2 * k;
            if ( mx < h && ar[mx - 1] < ar[mx]) {
                mx++;
            }
            if (ar[k - 1] >= ar[mx - 1]){
                break;
            }
            swap(ar,k,mx);
            k=mx;
        }
    }

    public static void swap(int[] ar,int i, int j) { //exch
        int tmp = ar[i-1];
        ar[i-1] = ar[j-1];
        ar[j-1] = tmp;
    }

   public static void print(int[] ar){
       for(int i=0;i<ar.length;i++){
           System.out.print(ar[i]+" ");
       }
       System.out.println();
   }

    public static void main(String[] args) {
        int[] a = {2,5,60,50,11,12,6,7,23,9,10,35};
        print(a);
        sort(a);
        print(a);
    }
}
