package com.fyiernzy.solution;

import com.fyiernzy.Solution;
import org.apache.commons.lang3.Validate;

import java.util.stream.IntStream;

public class MySolution implements Solution {
    @Override
    public double[][] addition(double[][] a, double[][] b) {
        validateSameDimension(a, b);
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    @Override
    public double[][] subtraction(double[][] a, double[][] b) {
        validateSameDimension(a, b);
        double[][] c = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    @Override
    public double[][] multiplication(double[][] a, double[][] b) {
        validateArray(a, b);
        Validate.isTrue(a[0].length == b.length, "Matrices are not compatible for multiplication");
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    @Override
    public double[] determinants(double[][][] a) {
        double[] determinants = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            determinants[i] = getDeterminant(a[i]);
        }
        return determinants;
    }

    @Override
    public double[][] inverse(double[][] a) {
        double determinant = getDeterminant(a);
        if (determinant == 0)
            return null;

        double[][] cofactor = cofactor(a);
        double[][] transpose = transpose(cofactor);
        double[][] inverse = new double[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                inverse[i][j] = transpose[i][j] / determinant;
            }
        }

        return inverse;
    }

    @Override
    public String removeSpecialCharacters(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }

    @Override
    public boolean isPalindrome(String string) {
        string = removeSpecialCharacters(string).toLowerCase();
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    @Override
    public int[] generatePrimes(int lower, int upper) {
        if (upper < 2 || lower > upper) {
            return new int[0];
        }
        return IntStream.rangeClosed(lower, upper)
                .filter(this::isPrime)
                .toArray();
    }

    private boolean isPrime(int num) {
        if (num < 2 || num % 2 == 0 && num != 2) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private double getDeterminant(double[][] a) {
        validateSquareMatrix(a);

        boolean hasOnlyOneElement = a.length == 1;
        if (hasOnlyOneElement) {
            return a[0][0];
        }

        double determinant = 0;
        for (int i = 0; i < a.length; i++) {
            double[][] subMatrix = getSubMatrix(a, 0, i);
            determinant += Math.pow(-1, i) * a[0][i] * getDeterminant(subMatrix);
        }
        return determinant;
    }

    private double[][] getSubMatrix(double[][] a, int excludingRow, int excludingCol) {
        double[][] subMatrix = new double[a.length - 1][a.length - 1];
        int r = -1;

        for (int i = 0; i < a.length; i++) {
            if (i == excludingRow) {
                continue;
            }
            r++;
            int c = -1;

            for (int j = 0; j < a.length; j++) {
                if (j == excludingCol) {
                    continue;
                }
                subMatrix[r][++c] = a[i][j];
            }
        }
        return subMatrix;
    }


    private double[][] cofactor(double[][] a) {
        int n = a.length;
        double[][] cofactor = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactor[i][j] = Math.pow(-1, i + j) * getDeterminant(getSubMatrix(a, i, j));
            }
        }
        return cofactor;
    }

    private double[][] transpose(double[][] cofactor) {
        int n = cofactor.length;
        double[][] transpose = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = cofactor[i][j];
            }
        }
        return transpose;
    }

    private void validateSquareMatrix(double[][] a) {
        validateArray(a);
        for(double[] row : a) {
            Validate.isTrue(row.length == a.length, "Matrix must be square");
        }
    }

    private void validateSameDimension(double[][] a, double[][] b) {
        validateArray(a, b);
        Validate.isTrue(a.length == b.length, "Matrices must have the same dimension");
        for (int i = 0; i < a.length; i++) {
            Validate.isTrue(a[i].length == b[i].length, "Matrices must have the same dimension");
        }
    }

    private void validateArray(double[][] a, double[][] b) {
        Validate.notEmpty(a, "Matrix a must not be empty");
        Validate.notEmpty(b, "Matrix b must not be empty");
    }

    private void validateArray(double[][] a) {
        Validate.notEmpty(a, "Matrix must not be empty");
    }
}
