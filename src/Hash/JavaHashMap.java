package Hash;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class JavaHashMap {
    public static void main(String[] args) {
        HashMap<String,Student> students = new HashMap<String, Student>();
        Student s1 = new Student("Ece",1021,3.0f);
        Student s2 = new Student("Kemal",2029,2.0f);
        Student s3 = new Student("Aylin",5013,1.8f);
        Student s4 = new Student("Poyraz",5956,3.6f);

        students.put(s1.name, s1);
        students.put(s2.name, s2);
        students.put(s3.name, s3);
        students.put(s4.name, s4);
        System.out.println("students= " + students);
        System.out.println("students.size()= " + students.size());
        System.out.println("students.keySet()= " + students.keySet());
        System.out.println("students.values()= " + students.values());
        System.out.println("students.get(Ece)= "+ students.get(s1.name));
        System.out.println("students.remove(Kemal)= "+ students.remove(s2.name));
        System.out.println("students.get(Kemal)= "+ students.get(s2.name));
        System.out.println("students= " + students);
        System.out.println("students.size()= " + students.size());

        HashMap<String,String> dictionary = new HashMap<String, String>();
        try{
            File myObject = new File("dictionary.txt");
            Scanner myReader = new Scanner(myObject);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                String[] stringArray = data.split(" ");
                dictionary.put(stringArray[0],stringArray[1]);
            }
            myReader.close();
        }catch (Exception e){

        }

        System.out.println("----------------------------");
        System.out.println("dictionary= " + dictionary);
        System.out.println("dictionary.size()= " + dictionary.size());
        System.out.println("dictionary.keySet()= " + dictionary.keySet());
        System.out.println("dictionary.values()= " + dictionary.values());
        System.out.println("dictionary.get(computer)= "+ dictionary.get("computer"));
    }
}