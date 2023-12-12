package Y2324.Viva2.cout;
public class Solution {

    public static double[][] addition(double[][] arr1, double arr2[][])
    {
        double[][] arr = new double[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
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

    public double[] determinant(double[][][] a) {
        // Implement this method
        return null;
    }

    public double[][] inverse(double[][] a) {
        // Implement this method
        return null;
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
