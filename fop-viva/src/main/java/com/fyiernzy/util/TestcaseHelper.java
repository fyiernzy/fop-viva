package com.fyiernzy.util;

import com.fyiernzy.Solution;

import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

/**
 * A utility class that provides helper methods for generating test matrices,
 * matrix collections, and dynamically loading implementations of the {@link Solution} interface.
 */
public class TestcaseHelper {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    /**
     * Generates a matrix with random values between -10 and 10.
     *
     * @param rows the number of rows in the matrix
     * @param cols the number of columns in the matrix
     * @return a 2D array (matrix) with random values
     */
    public static double[][] matrix(int rows, int cols) {
        return matrix(rows, cols, -10, 10);
    }

    /**
     * Generates a matrix with random values in the specified range.
     *
     * @param rows the number of rows in the matrix
     * @param cols the number of columns in the matrix
     * @param min  the minimum value (inclusive) for random generation
     * @param max  the maximum value (exclusive) for random generation
     * @return a 2D array (matrix) with random values
     */
    public static double[][] matrix(int rows, int cols, double min, double max) {
        return IntStream.range(0, rows)
                .mapToObj(r -> RANDOM.doubles(cols, min, max).toArray())
                .toArray(double[][]::new);
    }

    /**
     * Generates a collection of matrices with random values in the specified range.
     *
     * @param num  the number of matrices to generate
     * @param rows the number of rows in each matrix
     * @param cols the number of columns in each matrix
     * @param min  the minimum value (inclusive) for random generation
     * @param max  the maximum value (exclusive) for random generation
     * @return a 3D array (collection of matrices) with random values
     */
    public static double[][][] matrices(int num, int rows, int cols, double min, double max) {
        return IntStream.range(0, num)
                .mapToObj(i -> matrix(rows, cols, min, max))
                .toArray(double[][][]::new);
    }

    /**
     * Dynamically loads and initializes an implementation of the {@link Solution} interface
     * using its fully qualified class name.
     *
     * @param fullyQualifiedName the fully qualified name of the class to load
     * @return an instance of the specified {@link Solution} implementation
     * @throws RuntimeException if the class cannot be found, instantiated, or does not implement {@link Solution}
     */
    public static Solution getImplementation(String fullyQualifiedName) {
        try {
            Class<?> clazz = Class.forName(fullyQualifiedName);
            return (Solution) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to instantiate: " + fullyQualifiedName, ex);
        }
    }

    /**
     * Finds all implementations of the {@link Solution} interface within the
     * package `com.fyiernzy.solution`.
     *
     * @return a set of all discovered {@link Solution} implementations
     */
    public static Set<Solution> getImplementations() {
        return ReflectionHelper.findImplementations("com.fyiernzy.solution", Solution.class);
    }
}

