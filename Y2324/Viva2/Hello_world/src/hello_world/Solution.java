/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//test
package hello_world;

import java.util.ArrayList;
import java.util.Scanner;

//pls work

/**
 *
 * @author ASUS
 */
public class Solution {
    public static int size = 3;
    public static void main(String[] args) {
        q2();
    }
    
    public static int[][] addition(int[][] matric1, int[][] matric2) {
        int[][] result = new int [size][size];
        
        for(int i = 0; i< size; i++){
            for(int j = 0; j < size; j++){
                result[i][j] = matric1[i][j] + matric2[i][j];
            }
        }   
        return result;
    }

    public static int[][] subtraction(int[][] matric1, int[][] matric2) {
        int[][] result = new int [size][size];
        
        for(int i = 0; i< size; i++){
            for(int j = 0; j < size; j++){
                result[i][j] = matric1[i][j] - matric2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplication(int[][] matric1, int[][] matric2) {
        int[][] result = new int [size][size];
        
        for(int i = 0; i< size; i++){
            for(int j = 0; j < size; j++){
                for (int k = 0; k < size; k++) {
                    result[i][j] += matric1[i][k] * matric2[k][j];
                }       
            }
        }
        return result;
    }

    public static int determinant(int[][] matrix) {
        
        int determinant = 0;
        if(size == 3){
            
            determinant += matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2]);
            determinant -= matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[2][0] * matrix[1][2]);
            determinant += matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]);
            
        }else if(size == 2){
            
            determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        
        
        return determinant;
    }

    
    public static double[][] inverse(int[][] matrix, int determinant) {
        
         double[][] inverse = new double[size][size];
         double[][] adjoint = new double[size][size];
         
         if(size == 3){
             
            adjoint[0][0] = matrix[1][1]*matrix[2][2] - matrix[2][1]*matrix[1][2];
            adjoint[0][1] = -(matrix[0][1]*matrix[2][2] - matrix[2][1]*matrix[0][2]);
            adjoint[0][2] = matrix[0][1]*matrix[1][2] - matrix[1][1]*matrix[0][2];

            adjoint[1][0] = -(matrix[1][0]*matrix[2][2] - matrix[2][0]*matrix[1][2]);
            adjoint[1][1] = matrix[0][0]*matrix[2][2] - matrix[2][0]*matrix[0][2];
            adjoint[1][2] = -(matrix[0][0]*matrix[1][2] - matrix[1][0]*matrix[0][2]);

            adjoint[2][0] = matrix[1][0]*matrix[2][1] - matrix[2][0]*matrix[1][1];
            adjoint[2][1] = -(matrix[0][0]*matrix[2][1] - matrix[2][0]*matrix[0][1]);
            adjoint[2][2] = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];

            for(int i = 0; i< size; i++){
               for(int j = 0; j < size; j++){
                   inverse[i][j] = adjoint[i][j]/determinant;
               }
            }
         }else if(size == 2){
             
            adjoint[0][0] = matrix[1][1];
            adjoint[0][1] = -(matrix[0][1]);
            
            adjoint[1][0] = -(matrix[1][0]);
            adjoint[1][1] = matrix[0][0];
            
            for(int i = 0; i< size; i++){
               for(int j = 0; j < size; j++){
                   inverse[i][j] = adjoint[i][j]/determinant;
               }
            }
         }
         
         
        
        return inverse;
    }

    public static String removeSpecialCharacters(String str) {
        String cleanstr = str.replaceAll("[^a-zA-Z0-9]", "");
        cleanstr = cleanstr.toLowerCase();
        return  cleanstr;
    }

    public static boolean isPalindrome(String str) {
        System.out.printf("Original string: %s\n", str);
        String cleanstr = removeSpecialCharacters(str);
        String reversestr = "";
        for (int i=cleanstr.length()-1; i>-1; i--){
            reversestr = reversestr + cleanstr.charAt(i);
        }
        System.out.printf("Reversed string: %s\n", reversestr);
        return(reversestr.equals(cleanstr));
    }

     public static ArrayList<Integer> generatePrimes(int lower, int upper){
        ArrayList<Integer>prime=new ArrayList<>();
        
        //lower and upper limit inclusive in the range
        for(int i=lower; i<=upper;i++){ 
            if(isPrime(i)){
               prime.add(i);
            }
        }return prime;
   }
     private static boolean isPrime(int number){
        if (number <= 1) { //prime num starts with 2
            return false;
        }
        
        //check if is a prime number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {  
                return false;
            }
        }

        return true;
    }
     
     public static void q3(){
         //prompt user to input value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lower limit of the range: ");
        int lower = sc.nextInt();
        
        if (lower<0 || lower==0){
            System.out.println("Invalid. Please enter a positive integer");
            return;
        }
      
                
        System.out.println("Enter the upper limit of the range: ");
        int upper = sc.nextInt();
        
        if (upper<=lower){
            System.out.println("Invalid. Please enter a positive integer greater than lower limit");
            return;
        }
                
        ArrayList<Integer> prime = generatePrimes(lower, upper);
        
        System.out.printf("The prime numbers within the range [%d,%d] are: [", lower, upper);
        for (int i:prime){
            System.out.print(i + " ");
        }System.out.print("]");

     }
     
     public static void q2(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string to determine if it is a palindrome: ");
        System.out.printf("%s %s", "The input", isPalindrome(input.nextLine())==true? "is a palindrome.":"is not a palindrome.");
     }
}