/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hello_world;

/**
 *
 * @author ASUS
 */
public class Solution {
    public static int size = 3;
    
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

    public String removeSpecialCharacters(String string) {
        // Implement this method
        return null;
    }

    public boolean isPalindrome(String string) {
        // Implement this method
        return true;
    }

    public int[] generatePrimes(int lower, int upper) {
        // Implement this method
        return null;
    }
}
