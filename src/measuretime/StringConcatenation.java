package measuretime;

/**
 *
 * @author suayb25
 */

public class StringConcatenation {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        repeat1('a',5);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime-startTime);
        System.out.println("Finish time= "+elapsedTime);
    }

    public static String repeat1(char c,int n){
        String answer="";
        for (int i=0;i<n;i++){
            answer+="c";
        }
        return answer;
    }

    public static String repeat2(char c,int n){
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append("c");
        }
        return sb.toString();
    }
}