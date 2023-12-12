/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello_world;

import java.util.ArrayList;
import java.util.Scanner;

public class q3Endong {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lower limit of the range: ");
        int lowerLimit = scanner.nextInt();

        System.out.print("Enter the upper limit of the range: ");
        int upperLimit = scanner.nextInt();

        if (lowerLimit < 2) {
            System.out.println("Lower limit should be greater than 1.");
            System.exit(0);
        }

        if (upperLimit < lowerLimit) {
            System.out.println("Upper limit should be greater than lower limit.");
            System.exit(0);
        }
        
        if (upperLimit == lowerLimit) {
            System.out.println("Upper limit cannot be the same as lower limit.");
            System.exit(0);
        }

        ArrayList<Integer> primes = generatePrimes(lowerLimit, upperLimit);

        System.out.println("The prime numbers within the range [" + lowerLimit + ", " + upperLimit + "] are: " + primes);
    }

    private static ArrayList<Integer> generatePrimes(int lowerLimit, int upperLimit) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int num = lowerLimit; num <= upperLimit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
