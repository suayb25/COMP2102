package measuretime;

/**
 *
 * @author suayb25
 */

public class Disjoint {
    public static void main(String[] args) {
        int[] A = new int[10];
        int[] B = new int[10];
        int[] C = new int[10];
        fillArrayWithRandomNumbers(A);
        fillArrayWithRandomNumbers(B);
        fillArrayWithRandomNumbers(C);
        long startTime = System.nanoTime();
        disjoint1(A,B,C);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime-startTime);
        System.out.println("Finish time= "+elapsedTime);
    }

    public static boolean disjoint1(int[] A,int[] B,int[] C){
        for(int a=0;a<A.length;a++){
            for (int b=0;b<B.length;b++){
                for (int c=0;c<C.length;c++){
                    if(A[a]==B[b] || B[b]==C[c]){
                        return false;               //we found common value
                    }
                }
            }
        }
        return true;                                //if we reach this, sets are disjoint
    }

    public static boolean disjoint2(int[] A,int[] B,int[] C){
        for(int a=0;a<A.length;a++){
            for (int b=0;b<B.length;b++){
                if(A[a]==B[b]){                     //only check C when we find match from A and B
                    for (int c=0;c<C.length;c++){
                        if(A[a]==C[c]){             //and thus b==c as well
                            return false;           //we dound a common value
                        }
                    }
                }
            }
        }
        return true;                                //if we reach this, sets are disjoint
    }

    public static void fillArrayWithRandomNumbers(int[] Array){
        for (int i=0;i<Array.length;i++){
            Array[i]=(int)(Math.random()*10 +1);
            System.out.println(Array[i]);
        }
    }
}