/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello_world;

import java.util.ArrayList;
import java.util.Scanner;
public class q3Xingyi {
       public static void main(String[] args) {
        //prompt user to input value
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lower limit of the range: ");
        int lower = sc.nextInt();
        if (lower<0){
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
}
