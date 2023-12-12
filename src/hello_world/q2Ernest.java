/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello_world;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;
public class q2Ernest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to determine if it is a palindrome: ");;
        System.out.printf("%s %s", "The input", isPalindrome(input.nextLine())==true? "is a palindrome.":"is not a palindrome.");
    }
    
    public static String removeSpecialCharacters(String str){
        String cleanstr = str.replaceAll("[^a-zA-Z0-9]", "");
        cleanstr = cleanstr.toLowerCase();
        return  cleanstr;
    }
    
    private static boolean isPalindrome (String str){
        System.out.printf("Original string: %s\n", str);
        String cleanstr = removeSpecialCharacters(str);
        String reversestr = "";
        for (int i=cleanstr.length()-1; i>-1; i--){
            reversestr = reversestr + cleanstr.charAt(i);
        }
        System.out.printf("Reversed string: %s\n", reversestr);
        return(reversestr.equals(cleanstr));
    }
}

