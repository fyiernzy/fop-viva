package com.fyiernzy.suite;

import com.fyiernzy.Solution;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3TestSuite extends AbstractTestSuite {
    public Q3TestSuite(Solution scheme, Solution solution) {
        super(scheme, solution);
    }

    @Override
    public void runTests() {
        testGeneratePrimes();
    }

    void testGeneratePrimes() {
        generatePrimesCases().forEach(args -> {
            int lower = args[0];
            int upper = args[1];
            assertThat(solution.generatePrimes(lower, upper)).isEqualTo(scheme.generatePrimes(lower, upper));
        });
    }

    List<int[]> generatePrimesCases() {
        return List.of(
                new int[] { 1, 10 },
                new int[] { 10, 20 },
                new int[] { 20, 20 },
                new int[] { 0, 2 },
                new int[] { -10, 10 }
        );
    }
}

