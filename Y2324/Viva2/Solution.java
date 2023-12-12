import java.util.Scanner;
public class Solution {
/*
    public double[][] addition(double[][] a, double[][] b) {
        // Implement this method
        return null;
    }

    public double[][] subtraction(double[][] a, double[][] b) {
        // Implement this method
        return null;
    }

    public double[][] multiplication(double[][] a, double[][] b) {
        // Implement this method
        return null;
    }

    public double[] determinant(double[][][] a) {
        // Implement this method
        return null;
    }

    public double[][] inverse(double[][] a) {
        // Implement this method
        return null;
    }
*/
    public void q2b (){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to determine if it is a palindrome: ");
        System.out.printf("%s %s", "The input", isPalindrome(input.nextLine())==true? "is a palindrome.":"is not a palindrome.");
    }

    public String removeSpecialCharacters(String str) {
        String cleanstr = str.replaceAll("^[^a-zA-Z0-9]$", "");
        cleanstr = cleanstr.toLowerCase();
        return  cleanstr;
    }

    public boolean isPalindrome(String str) {
        System.out.printf("Original string: %s\n", str);
        String cleanstr = removeSpecialCharacters(str);
        String reversestr = "";
        for (int i=cleanstr.length()-1; i>-1; i--){
            reversestr = reversestr + cleanstr.charAt(i);
        }
        System.out.printf("Reversed string: %s\n", reversestr);
        return(reversestr.equals(cleanstr));
    }
/* 
    public int[] generatePrimes(int lower, int upper) {
        // Implement this method
        return null;
    }
    */
}