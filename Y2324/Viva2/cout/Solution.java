package Y2324.Viva2.cout;
public class Solution {

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

    public static double[] determinant(double[][] array) {
        
        double[] arr = new double[1];

        double inner1 = array[1][1] * array[2][2] - array[1][2] * array[2][1];
        double inner2 = array[1][0] * array[2][2] - array[1][2] * array[2][0];
        double inner3 = array[1][0] * array[2][1] - array[1][1] * array[2][0];

        arr[0] = (array[0][0] * inner1) - (array[0][1] * inner2) + (array[0][2] * inner3);

        return arr;
    }

    public static double[][] inverse(double[][] array) {
        double[][] cofactors = new double[array.length][array.length];

        int a = 1, b = 2, p = 1, q = 2;

        for (int i = 0; i < array.length; i++) {
            if (i >= p && p > 0) {
                p--;
            }

            if (i >= q && q > 0) {
                q--;
            }
            for (int j = 0; j < array[i].length; j++) {
                if (j >= a && a > 0) {
                    a--;
                }

                if (j >= b && b > 0) {
                    b--;
                }

                cofactors[i][j] = array[p][a] * array[q][b] - array[p][b] * array[q][a];
                cofactors[i][j] *= (Math.pow(-1, i + j));
            }
            a = 1;
            b = 2;
        }

        double[][] transposeMatrix = new double[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                transposeMatrix[j][i] = cofactors[i][j];
            }
        }

        double[] det = determinant(array);

        double[][] inverse = new double[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                inverse[i][j] = 1.0 / det[0] * transposeMatrix[i][j];
            }
        }

        return inverse;
    }

    public String removeSpecialCharacters(String n) {
        String result = n.replaceAll("[^A-Za-z0-9]", "");
        return result;
    }

    public boolean isPalindrome(String n) {
        String cleanedString = removeSpecialCharacters(n);
        return cleanedString.equals(new StringBuilder(cleanedString).reverse().toString());
    }

    public int[] generatePrimes(int lower, int upper) {
        int[] primes = new int[upper - lower];
        int count = 0;

        for(int i = lower; i <= upper; i++) {
            boolean valid = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    valid = false;
                    break; 
                }
            }

            if (valid) {
                primes[count] = i;
                count++;
            }
        }
        return primes;
<<<<<<< HEAD
=======
 }
>>>>>>> acfaa9931d0112946e25e7480ff25d0c0c6c3b62
}
