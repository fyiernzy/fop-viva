package com.fyiernzy;

/**
 * The Solution interface defines the required methods for the Viva implementation.
 * Implementing classes must provide concrete logic for matrix operations, string processing,
 * and prime number generation.
 */
public interface Solution {

    /**
     * Adds two matrices and returns their sum.
     * Both matrices must have the same dimensions.
     *
     * @param a the first matrix
     * @param b the second matrix
     * @return the sum of the two matrices
     * @throws IllegalArgumentException if the dimensions of the matrices do not match
     */
    double[][] addition(double[][] a, double[][] b);

    /**
     * Subtracts the second matrix from the first matrix and returns the result.
     * Both matrices must have the same dimensions.
     *
     * @param a the first matrix
     * @param b the second matrix
     * @return the difference of the two matrices
     * @throws IllegalArgumentException if the dimensions of the matrices do not match
     */
    double[][] subtraction(double[][] a, double[][] b);

    /**
     * Multiplies two matrices and returns the resulting matrix.
     * The number of columns in the first matrix must match the number of rows in the second matrix.
     *
     * @param a the first matrix
     * @param b the second matrix
     * @return the resulting matrix from the multiplication
     * @throws IllegalArgumentException if the matrices are not compatible for multiplication
     */
    double[][] multiplication(double[][] a, double[][] b);

    /**
     * Computes the determinants of multiple square matrices.
     * Each matrix must be square (i.e., number of rows equals number of columns).
     *
     * @param a an array of square matrices
     * @return an array of determinants for the input matrices
     * @throws IllegalArgumentException if any of the matrices are not square
     */
    double[] determinants(double[][][] a);

    /**
     * Computes the inverse of a square matrix.
     * The matrix must be invertible (i.e., its determinant is non-zero).
     *
     * @param a the input square matrix
     * @return the inverse of the matrix, or {@code null} if the matrix is not invertible
     * @throws IllegalArgumentException if the matrix is not square
     */
    double[][] inverse(double[][] a);

    /**
     * Removes all special characters from a given string, leaving only alphanumeric characters.
     *
     * @param string the input string
     * @return the string with all non-alphanumeric characters removed
     */
    String removeSpecialCharacters(String string);

    /**
     * Determines whether a given string is a palindrome.
     * A palindrome reads the same backward as forward. The check is case-insensitive and ignores
     * special characters.
     *
     * @param string the input string
     * @return {@code true} if the string is a palindrome; {@code false} otherwise
     */
    boolean isPalindrome(String string);

    /**
     * Determines whether a given string is a valid palindrome.
     * A valid palindrome considers only alphanumeric characters and ignores case.
     * For example, "A man, a plan, a canal: Panama" is considered a valid palindrome.
     *
     * @param string the input string
     * @return {@code true} if the string is a valid palindrome; {@code false} otherwise
     */
    boolean isValidPalindrome(String string);

    /**
     * Generates all prime numbers within a specified range.
     * The range is inclusive of both {@code lower} and {@code upper}.
     *
     * @param lower the lower bound of the range
     * @param upper the upper bound of the range
     * @return an array of prime numbers within the range, or an empty array if no primes are found
     * @throws IllegalArgumentException if {@code lower > upper}
     */
    int[] generatePrimes(int lower, int upper);
}

