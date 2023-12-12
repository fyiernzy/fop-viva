/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello_world;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class q2Teh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Please enter a string");
        String input = sc.nextLine();
        
        if(isPalindrome(removeSpecialCharacters(input))) 
            System.out.println("The string is a palindrome");
        else System.out.println("The string is not a palindrome"); 
        
        System.out.println(reverseSpecialCharacters(input));
    }
    
    
    public static boolean isPalindrome(String word){
        StringBuilder sb = new StringBuilder(word);
        String reverse = sb.reverse().toString();
        
        if (reverse.equalsIgnoreCase(word))
            return true;
        return false;
    }
    public static String removeSpecialCharacters(String word){
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()){
            if (Character.isLetterOrDigit(ch) || Character.isWhitespace(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    static String reverseSpecialCharacters(String inputString) {
        StringBuilder reversedSpecialChars = new StringBuilder();

        for (char ch : inputString.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                reversedSpecialChars.insert(0, Character.toString(ch));
            }
        }
        return reversedSpecialChars.toString();
    }
}
