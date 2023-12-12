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
public class q1 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int[][] matric1 = new int[3][3];
        int[][] matric2 = new int[3][3];
        int[][] result_addition = new int [3][3];
        int[][] result_subtraction = new int [3][3];
        int[][] result_multiplication = new int [3][3];
        int[][] inverseA = new int [3][3];
        int[][] inverseB = new int [3][3];
        int determinantA , determinantB;
  
        System.out.println("Please enter the  matrix A of dimension 3x3");
        for(int i = 0; i<matric1.length; i++){
            for(int j = 0; j < matric1.length; j++){
                matric1[i][j] = sc.nextInt();
            }
        }
        
        System.out.println();
        
        System.out.println("Please enter the  matrix B of dimension 3x3");
        for(int i = 0; i<matric2.length; i++){
            for(int j = 0; j < matric2.length; j++){
                matric2[i][j] = sc.nextInt();
            }
        }
        
        //Addition
        result_addition = addition(matric1, matric2);
        
        System.out.println();
        
        System.out.println("Result of additon for 2 matrices");
        for(int i = 0; i<result_addition.length; i++){
            for(int j = 0; j < result_addition.length; j++){
                System.out.print(result_addition[i][j] + " ");
            }
            System.out.println();
        }
        
        //Subtraction
        result_subtraction = subtraction(matric1, matric2);
        
        System.out.println();
        
        System.out.println("Result of subtraction for 2 matrices");
        for(int i = 0; i<result_subtraction.length; i++){
            for(int j = 0; j < result_subtraction.length; j++){
                System.out.print(result_subtraction[i][j] + " ");
            }
            System.out.println();
        }
        
        //Multiplication
        result_multiplication = multiplication(matric1, matric2);
        
        System.out.println();
        
        System.out.println("Result of multiplication for 2 matrices");
        for(int i = 0; i<result_multiplication.length; i++){
            for(int j = 0; j < result_multiplication.length; j++){
                System.out.print(result_multiplication[i][j] + " ");
            }
            System.out.println();
        }
        
        
        //Determinant
        determinantA = determinant(matric1);
        determinantB = determinant(matric2);
        
        System.out.println();
        System.out.println("Determinant for matrix A is " + determinantA);
        System.out.println("Determinant for matrix B is " + determinantB);
        
        
        inverseA = inverse(matric1, determinantA);
        inverseB = inverse(matric2, determinantB);
        
        
        System.out.println();
        
        System.out.println("Inverse of matrix A: ");
        for(int i = 0; i<inverseA.length; i++){
            for(int j = 0; j < inverseA.length; j++){
                System.out.print(inverseA[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Inverse of matrix B: ");
        for(int i = 0; i<inverseB.length; i++){
            for(int j = 0; j < inverseB.length; j++){
                System.out.print(inverseB[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] addition(int[][] matric1, int[][] matric2) {
        int[][] result = new int [3][3];
        for(int i = 0; i<matric2.length; i++){
            for(int j = 0; j < matric2.length; j++){
                result[i][j] = matric1[i][j] + matric2[i][j];
            }
        }   
        return result;
    }
    
    
    public static int[][] subtraction(int[][] matric1, int[][] matric2) {
        int[][] result = new int [3][3];
        for(int i = 0; i<matric2.length; i++){
            for(int j = 0; j < matric2.length; j++){
                result[i][j] = matric1[i][j] - matric2[i][j];
            }
        }
        return result;
    }
    
    
    public static int[][] multiplication(int[][] matric1, int[][] matric2) {
        int[][] result = new int [3][3];
        for(int i = 0; i<matric2.length; i++){
            for(int j = 0; j < matric2.length; j++){
                for (int k = 0; k < matric2.length; k++) {
                    result[i][j] += matric1[i][k] * matric2[k][j];
                }       
            }
        }
        return result;
    }
    
    
    public static int determinant(int[][] matrix) {
        
        int determinant = 0;
        
        determinant += matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[2][1] * matrix[1][2]);
        determinant -= matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[2][0] * matrix[1][2]);
        determinant += matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[2][0] * matrix[1][1]);
        
        return determinant;
    }
    
    
    public static int[][] inverse(int[][] matrix, int determinant) {
        
         int[][] inverse = new int[3][3];
         int[][] adjoint = new int[3][3];
         
         adjoint[0][0] = matrix[1][1]*matrix[2][2] - matrix[2][1]*matrix[1][2];
         adjoint[0][1] = -(matrix[0][1]*matrix[2][2] - matrix[2][1]*matrix[0][2]);
         adjoint[0][2] = matrix[0][1]*matrix[1][2] - matrix[1][1]*matrix[0][2];
         
         adjoint[1][0] = -(matrix[1][0]*matrix[2][2] - matrix[2][0]*matrix[1][2]);
         adjoint[1][1] = matrix[0][0]*matrix[2][2] - matrix[2][0]*matrix[0][2];
         adjoint[1][2] = -(matrix[0][0]*matrix[1][2] - matrix[1][0]*matrix[0][2]);
         
         adjoint[2][0] = matrix[1][0]*matrix[2][1] - matrix[2][0]*matrix[1][1];
         adjoint[2][1] = -(matrix[0][0]*matrix[2][1] - matrix[2][0]*matrix[0][1]);
         adjoint[2][2] = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1];
         
        for(int i = 0; i<adjoint.length; i++){
           for(int j = 0; j < adjoint.length; j++){
               inverse[i][j] = adjoint[i][j]/determinant;
           }
       }
        
        return inverse;
    }
}

