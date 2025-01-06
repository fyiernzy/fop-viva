package com.fyiernzy.suite;

import com.fyiernzy.Solution;
import com.fyiernzy.util.TestcaseHelper;
import org.junit.jupiter.params.provider.Arguments;

import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1TestSuite extends AbstractTestSuite {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 6;
    private static final int NUM_MATRICES = 5;
    private static final int MIN_VALUE = -10;
    private static final int MAX_VALUE = 10;

    public Q1TestSuite(Solution scheme, Solution solution) {
        super(scheme, solution);
    }

    @Override
    public void runTests() {
        runAdditionTests();
        runSubtractionTests();
        runMultiplicationTests();
        runDeterminantTests();
        runInverseTests();
    }

    private void runAdditionTests() {
        runMatrixPairTests("Addition", solution::addition, scheme::addition);
    }

    private void runSubtractionTests() {
        runMatrixPairTests("Subtraction", solution::subtraction, scheme::subtraction);
    }

    private void runMultiplicationTests() {
        runMatrixPairTests("Multiplication", solution::multiplication, scheme::multiplication);
    }

    private void runDeterminantTests() {
        matrices().forEach(args -> {
            double[][][] testMatrices = (double[][][]) args.get()[0];
            int size = testMatrices[0].length;
            assertThat(solution.determinants(testMatrices))
                    .as("Determinants Test for %sX%s Matrices: %s", size, size)
                    .isEqualTo(scheme.determinants(testMatrices));
        });
    }

    private void runInverseTests() {
        matrix().forEach(args -> {
            double[][] testMatrix = (double[][]) args.get()[0];
            assertThat(solution.inverse(testMatrix))
                    .as("Inverse Test for Matrix: %s", args)
                    .isEqualTo(scheme.inverse(testMatrix));
        });
    }

    private void runMatrixPairTests(String testType,
                                    BiFunction<double[][], double[][], double[][]> solutionFunction,
                                    BiFunction<double[][], double[][], double[][]> schemeFunction) {
        testCases().forEach(args -> {
            double[][] a = (double[][]) args.get()[0];
            double[][] b = (double[][]) args.get()[1];
            int size = a.length;
            assertThat(solutionFunction.apply(a, b))
                    .as("%s Test for %sX%s Matrices", testType, size, size)
                    .isEqualTo(schemeFunction.apply(a, b));
        });
    }

    private Stream<Arguments> testCases() {
        return IntStream.rangeClosed(MIN_SIZE, MAX_SIZE).mapToObj(size -> Arguments.of(
                TestcaseHelper.matrix(size, size),
                TestcaseHelper.matrix(size, size)
        ));
    }

    private Stream<Arguments> matrix() {
        return IntStream.rangeClosed(MIN_SIZE, MAX_SIZE).mapToObj(size -> Arguments.of(
                (Object) TestcaseHelper.matrix(size, size)
        ));
    }

    private Stream<Arguments> matrices() {
        return IntStream.rangeClosed(MIN_SIZE, MAX_SIZE).mapToObj(size -> Arguments.of(
                (Object) TestcaseHelper.matrices(NUM_MATRICES, size, size, MIN_VALUE, MAX_VALUE)
        ));
    }
}
