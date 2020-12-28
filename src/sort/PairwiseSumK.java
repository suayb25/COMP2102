package sort;

import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

public class PairwiseSumK {
    static boolean pairwiseSumK(int[] A, int N, int K) {
        int p;
        sort(A, 0, N - 1);
        for (int i = 0; i < N - 1; i++) {
            p = binarySearch(A,i+1,N,K-A[i]);
            if(p>=0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {88,102,400,1,4,67};
        System.out.println(pairwiseSumK(a,a.length,502));
    }

}
