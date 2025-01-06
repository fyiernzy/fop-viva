package com.fyiernzy;

import com.fyiernzy.suite.Q1TestSuite;
import com.fyiernzy.suite.Q2TestSuite;
import com.fyiernzy.suite.Q3TestSuite;
import com.fyiernzy.util.ReflectionHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PackageTest {
    @Nested
    class SolutionsTest {
        @MethodSource("getSolutionImplementations")
        @ParameterizedTest(name = "{0}")
        void runVivaTests(Solution solution) {
            Solution scheme = new Scheme();
            new Q1TestSuite(scheme, solution).runTests();
            new Q2TestSuite(scheme, solution).runTests();
            new Q3TestSuite(scheme, solution).runTests();
        }

        static Stream<Solution> getSolutionImplementations() {
            return ReflectionHelper.findImplementations("com.fyiernzy.solution", Solution.class).stream();
        }
    }
}
