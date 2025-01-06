package com.fyiernzy.util;

import com.fyiernzy.Solution;

import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class TestcaseHelper {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static double[][] matrix(int rows, int cols) {
        return matrix(rows, cols, -10, 10);
    }

    public static double[][] matrix(int rows, int cols, double min, double max) {
        return IntStream.range(0, rows)
                .mapToObj(r -> RANDOM.doubles(cols, min, max).toArray())
                .toArray(double[][]::new);
    }

    public static double[][][] matrices(int num, int rows, int cols, double min, double max) {
        return IntStream.range(0, num)
                .mapToObj(i -> matrix(rows, cols, min, max))
                .toArray(double[][][]::new);
    }

    public static Solution getImplementation(String fullyQualifiedName) {
        try {
            Class<?> clazz = Class.forName(fullyQualifiedName);
            return (Solution) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to instantiate: " + fullyQualifiedName, ex);
        }
    }

    public static Set<Solution> getImplementations() {
        return ReflectionHelper.findImplementations("com.fyiernzy.solution", Solution.class);
    }
}
