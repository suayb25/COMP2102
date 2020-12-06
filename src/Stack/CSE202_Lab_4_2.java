package Stack;

import java.util.Scanner;

public class CSE202_Lab_4_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a text= ");
        String userString = input.next();
        StringBuilder text = new StringBuilder(userString.toLowerCase()); //lowercase
        if(text.toString().equals("")){
            throw new IllegalArgumentException();
        }else{
            GenericStack<Character> genericStack2 = new GenericStack<>(text.length());
            //Push all chars in stack
            for (int i = 0; i < text.length(); i++) {
                genericStack2.push(text.charAt(i)); //String.valueOf(text.charAt(i));
            }

            String reverseString = "";

            //Pop all chars from stack one by one and build reverse string
            while (!genericStack2.isEmpty()) {
                reverseString = reverseString + genericStack2.pop();
            }
            System.out.println("original text= " + text);
            System.out.println("reverseString= "+ reverseString);
            System.out.println("---------------------");

            //reverseString = new StringBuilder(text).reverse().toString(); //simple and good usage

            //Check palindrome string
            if (text.toString().equals(reverseString)) {
                System.out.println("String is a palindrome.");
            } else {
                System.out.println("String is not a palindrome.");
            }
        }
    }
}
