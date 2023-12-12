package Y2324.Viva2.cout;
public class Solution {


    public static double[][] addition(double[][] arr1, double arr2[][])
    {
        double[][] arr = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) { //arr1.length is for number of rows 
            for (int j = 0; j < arr1[i].length; j++) { //arr1[0].length for the number of colms
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr;
    }

    

    public static double[][] subtraction(double[][] arr1, double[][] arr2) {
        double[][] arr = new double[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr[i][j] = arr1[i][j] - arr2[i][j];
            }
        }
        return arr;
    }

    public static double[][] multiplication(double[][] arr1, double[][] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int p = arr1.length;

        double[][] arr = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    arr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return arr;
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
    }
}
