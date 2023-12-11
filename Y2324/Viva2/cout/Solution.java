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
