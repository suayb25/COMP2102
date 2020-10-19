package measuretime;

import java.io.IOException;

public class simpleTime {

    public static void main(String[] args) {
        try {
            main1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main1() throws IOException {
        long startTime = System.currentTimeMillis();  //represents the number of seconds that have passed since 00:00:00 UTC Thursday, 1 January 1970. (Unix Time Stamp)
        for (int i = 0; i < 10; i++) {
            System.out.println("i= " + i);
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("elapsed= " + elapsed);
    }

    public static void main2() throws IOException {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            System.out.println("i= " + i);
        }
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("elapsed= " + elapsed / 1000000000.0);  //1 nanosecond = 1.0 x 10^-9 seconds
        //Math.pow(10,9)
    }

}