package sort;

import static java.util.Arrays.sort;

public class Exercises {

    public static void nearestTwoNumbers(int[] A) {
        sort(A);//O(NlogN)
        int minDiff = A[1] - A[0];
        int index = 0;
        for (int i = 2; i < A.length; i++) {//O(N)
            if (minDiff > A[i] - A[i - 1]) {
                minDiff = A[i] - A[i - 1];
                index = i;
            }
        }
        System.out.println("Min Diff: " + A[index] + " - " + A[index - 1] + " = " + minDiff);
    }

    public static void diffAB(int[] A, int[] B) {
        int smallIndex;
        if (A.length <= B.length) {
            smallIndex = A.length;
        } else {
            smallIndex = B.length;
        }
        int i;
        int j = 0;
        for (i = 0; i < smallIndex;) {
            if (A[i] < B[j]) {
                System.out.print(A[i++] + " ");
            } else if (A[i] > B[j]) {
                System.out.print(B[j++] + " ");
            } else {
                j++;
                i++;
            }
        }

        if (A.length != smallIndex) {
            for (int k = i; k < A.length; k++) {
                System.out.print(A[k] + " ");
            }
        } else {
            for (int l = j; l < A.length; l++) {
                System.out.print(B[l] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 7, 2, 67, 8, 2, 1, 0};
        nearestTwoNumbers(a);

        int[] array1 = {2, 5, 85, 98, 100};
        int[] array2 = {3, 5, 88, 98, 105};
        diffAB(array1,array2);
    }

}
