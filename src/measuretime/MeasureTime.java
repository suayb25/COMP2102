/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measuretime;

/**
 *
 * @author btek
 */

import java.io.IOException;
import java.lang.management.*;
import java.io.PrintWriter;
 
public class MeasureTime {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        // call main1 
        try{
            main2();
        }
        catch(Exception e ){
            System.out.println("Did not work");
        }
    }
    
     public static void main1() throws IOException {
        PrintWriter pw = new PrintWriter("SumtoN.txt");
        sumtoN(1); // call one time to load method in the cache
     
        for (int n =16; n<=4*65536; n*=2){
            long startTime = System.nanoTime();
            sumtoN(n);
            long endTime = System.nanoTime();
            long elapsedTime = (endTime-startTime);
            //pw.printf("%d\t%d \n", n,elapsedTime);
            pw.println(n+"\t"+ elapsedTime);
        
        }
        pw.close();
    }
    
    public static void main2() throws IOException{
        // to get cpu time in java we need current thread object
        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
        System.out.println(bean.isCurrentThreadCpuTimeSupported());
        // get current time in NANO SECONDS
        PrintWriter pw = new PrintWriter("SumtoN_CPUTIME.txt");
        //long t1 = bean.getCurrentThreadCpuTime();
        
        for (int n =16; n<=16*8192; n*=2){
            long startTime = bean.getCurrentThreadCpuTime();
            doubleLoopSum(n);
            long endTime = bean.getCurrentThreadCpuTime();
            long elapsedTime = (endTime-startTime);
            pw.printf("%d\t%d \n", n,elapsedTime);
        }
        pw.close();
        /*int N = 16535; // try 16535*2, 16535*4,16535*8 
        long sum = doubleLoopSum(N);
        
        // get current time in NANO SECONDS
        long t2 = bean.getCurrentThreadCpuTime();*/
        //System.out.println(sum);
        //System.out.println((t2-t1)/1000000000.0);
    }
    
    // sum numbers 1 to N
    public static void sumtoN(int N){
        long sum =0; 
        for (int i = 1; i<=N;i++){
            sum+=i;
        }
    }
    
    // sum numbers [1..N]*[1..N]
    public static long doubleLoopSum(int N){
        long sum = 0;
        for (int i = 0; i< N; i++)
            for (int j = 0; j <N; j++)
               // for (int k = 0; k <1; k++)
                sum +=i*j;
        return sum;
    }
    
    
}
