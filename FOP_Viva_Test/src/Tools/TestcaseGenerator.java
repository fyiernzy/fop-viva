package Tools;

import java.util.Random;

public class TestcaseGenerator {
    private static Random random = new Random();

    public static int[][] matrixInt(int rows, int cols) {
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            mat[i] = intArray(cols, -10, 10);
        return mat;
    }

    public static double[][] matrix(int rows, int cols) {
        double[][] mat = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            mat[i] = doubleArray(cols, -10, 10);
        return mat;
    }

    public static double[][] matrix(int rows, int cols, double min, double max) {
        double[][] mat = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = randDouble(min, max);
        return mat;
    }

    public static double[][][] matrices(int num, int rows, int cols, double min, double max) {
        double[][][] matrices = new double[num][rows][cols];
        for (int i = 0; i < num; i++)
            matrices[i] = matrix(rows, cols, min, max);
        return matrices;
    }

    public static double[][][] matrices(int num, int rows, int cols) {
        return matrices(num, rows, cols, -10, 10);
    }

    public static int[] intArray(int num, int min, int max) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++)
            arr[i] = randInt(min, max);
        return arr;
    }

    public static double[] doubleArray(int num, double min, double max) {
        double[] arr = new double[num];
        for (int i = 0; i < num; i++)
            arr[i] = randDouble(min, max);
        return arr;
    }

    public static int randInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static double randDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    public static double randDouble(double min, double max, int decimalPlaces) {
        double d = randDouble(min, max);
        return Math.round(d * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
    }
}
