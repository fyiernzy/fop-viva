package Viva2;

import java.util.ArrayList;
import java.util.List;

import Tools.*;
import static Tools.Formatter.*;
import static Tools.MyAssert.*;
import static Tools.TestcaseGenerator.*;

public class Q1Tester extends Tester {
    private static final String ADDITION = "Addition";
    private static final String SUBTRACTION = "Subtraction";
    private static final String MULTIPLICATION = "Multiplication";
    private final static String DETERMINANT = "Determinant";
    private static final String INVERSE = "Inverse";

    private static final int LOWEST_DIMENSION = 2;
    private static final int HIGHEST_DIMENSION = 7;

    Q1Tester(Scheme scheme, Solution solution) {
        super("Matrix Operations", scheme, solution);
    }

    Q1Tester(Scheme scheme, Solution solution, boolean isShowErrorMessage) {
        super("Matrix Operations", scheme, solution, isShowErrorMessage);
    }

    @Override
    public boolean test() {
        List<double[][]> testCases = getTestCases();
        boolean isPassed = true;

        // Test cases for addition, subtraction, multiplication
        for (int i = 0; i < testCases.size(); i++) {
            double[][] a = testCases.get(i);
            double[][] b = testCases.get(++i);
            Log.logInfo("Test case " + (i / 2 + 1));

            isPassed &= testAddition(a, b);
            Timer.sleep();
            isPassed &= testSubtraction(a, b);
            Timer.sleep();
            isPassed &= testMultiplication(a, b);
            Timer.sleep();
            isPassed &= testInverse(a);
            Timer.sleep();
            isPassed &= testInverse(b);
            Timer.sleep();
        }

        Log.logInfo("Test case for determinant");
        // Test cases for determinant
        isPassed &= testDeterminant(matrices(randInt(5, 10), 3, 3));
        Timer.sleep();

        return isPassed;
    }

    boolean testDeterminant(double[][][] testCases) {
        double[] expected = scheme.determinant(testCases);
        double[] actual = solution.determinant(testCases);

        return assertEquals(expected, actual, new Info(DETERMINANT, 
                new String[][] { 
                    { "Matrices", "Some information is hidden" } }, 
                arrayToString(expected), 
                arrayToString(actual)));
    }

    boolean testAddition(double[][] a, double[][] b) {
        double[][] expected = scheme.addition(a, b);
        double[][] actual = solution.addition(a, b);
        return assertEquals(expected, actual, info(ADDITION, a, b, expected, actual));
    }

    boolean testSubtraction(double[][] a, double[][] b) {
        double[][] expected = scheme.subtraction(a, b);
        double[][] actual = solution.subtraction(a, b);
        return assertEquals(expected, actual, info(SUBTRACTION, a, b, expected, actual));
    }

    boolean testMultiplication(double[][] a, double[][] b) {
        double[][] expected = scheme.multiplication(a, b);
        double[][] actual = solution.multiplication(a, b);
        return assertEquals(expected, actual, info(MULTIPLICATION, a, b, expected, actual));
    }

    boolean testInverse(double[][] testCase) {
        double[][] expected = scheme.inverse(testCase);
        double[][] actual = solution.inverse(testCase);
        return assertEquals(expected, actual,
                 new Info(INVERSE, 
                            new String[][] { 
                                { "Matrix", matrixToString(testCase) } }, 
                            matrixToString(expected), 
                            matrixToString(actual)));
    }

    private List<double[][]> getTestCases() {
        List<double[][]> testCases = new ArrayList<>();
        for (int i = LOWEST_DIMENSION; i <= HIGHEST_DIMENSION; i++)
            for (int j = 0; j < 2; j++)
                testCases.add(matrix(i, i));
        return testCases;
    }

    private Info info(String testName, double[][] a, double[][] b, double[][] expected, double[][] actual) {
        return new Info(testName,
                new String[][] { 
                        { "Matrix A", matrixToString(a) },
                        { "Matrix B", matrixToString(b) } },
                matrixToString(expected),
                matrixToString(actual));
    }
}
