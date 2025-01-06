package com.fyiernzy;

public interface Solution {
    double[][] addition(double[][] a, double[][] b);

    double[][] subtraction(double[][] a, double[][] b);

    double[][] multiplication(double[][] a, double[][] b);

    double[] determinants(double[][][] a);

    double[][] inverse(double[][] a);

    String removeSpecialCharacters(String string);

    boolean isPalindrome(String string);

    boolean isValidPalindrome(String string);

    int[] generatePrimes(int lower, int upper);
}
