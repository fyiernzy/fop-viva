package com.fyiernzy;

import com.fyiernzy.util.TestcaseHelper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A test class that focuses on a single {@link Solution} implementation specified by its class name.
 *
 * <p>Unlike {@link PackageTest}, which dynamically detects and tests all {@link Solution} implementations,
 * this class tests only one specified implementation. It is useful for debugging or validating a specific
 * implementation.
 */
public class SingleTest {
    private final String className = "com.fyiernzy.solution.MySolution";
    private final Solution scheme = new Scheme();
    private final Solution mySolution = TestcaseHelper.getImplementation(className);

    @Nested
    class Q1 {
        @ParameterizedTest(name = "{2}")
        @MethodSource("testCases")
        public void testAddition(double[][] a, double[][] b, String testName) {
            assertThat(mySolution.addition(a, b)).isEqualTo(scheme.addition(a, b));
        }

        @ParameterizedTest(name = "{2}")
        @MethodSource("testCases")
        public void testSubtraction(double[][] a, double[][] b, String testName) {
            assertThat(mySolution.subtraction(a, b)).isEqualTo(scheme.subtraction(a, b));
        }

        @ParameterizedTest(name = "{2}")
        @MethodSource("testCases")
        public void testMultiplication(double[][] a, double[][] b, String testName) {
            assertThat(mySolution.multiplication(a, b)).isEqualTo(scheme.multiplication(a, b));
        }

        @ParameterizedTest(name = "{1}")
        @MethodSource("matrices")
        public void testDeterminants(double[][][] matrices, String testName) {
            assertThat(mySolution.determinants(matrices)).isEqualTo(scheme.determinants(matrices));
        }

        @ParameterizedTest(name = "{1}")
        @MethodSource("matrix")
        public void testInverse(double[][] matrix, String testName) {
            assertThat(mySolution.inverse(matrix)).isEqualTo(scheme.inverse(matrix));
        }

        static Stream<Arguments> testCases() {
            return IntStream.rangeClosed(3, 6)
                    .mapToObj(size -> Arguments.of(
                            TestcaseHelper.matrix(size, size),
                            TestcaseHelper.matrix(size, size),
                            String.format("Testcase for %dx%d matrices", size, size)
                    ));
        }

        static Stream<Arguments> matrix() {
            return IntStream.rangeClosed(3, 6).mapToObj(size -> Arguments.of(
                    TestcaseHelper.matrix(size, size),
                    String.format("Testcase for %dx%d matrix", size, size)
            ));
        }

        static Stream<Arguments> matrices() {
            final int num = 5, min = -10, max = 10;
            return IntStream.rangeClosed(3, 6)
                    .mapToObj(size -> Arguments.of(
                            TestcaseHelper.matrices(num, size, size, min, max),
                            String.format("Testcase for %dx%d matrices", size, size)
                    ));
        }
    }

    @Nested
    class Q2 {
        @ParameterizedTest(name = "{1}")
        @MethodSource("removeSpecialCharactersCases")
        public void testRemoveSpecialCharacters(String input, String testName) {
            assertThat(mySolution.removeSpecialCharacters(input)).isEqualTo(scheme.removeSpecialCharacters(input));
        }

        @ParameterizedTest(name = "{1}")
        @MethodSource("isPalindromeCases")
        public void testIsPalindrome(String input, String testName) {
            assertThat(mySolution.isPalindrome(input)).isEqualTo(scheme.isPalindrome(input));
        }

        @ParameterizedTest(name = "{1}")
        @MethodSource("isValidPalindromeCases")
        public void testIsValidPalindrome(String input, String testName) {
            assertThat(mySolution.isValidPalindrome(input)).isEqualTo(scheme.isValidPalindrome(input));
        }

        static Stream<Arguments> removeSpecialCharactersCases() {
            return Stream.of(
                    Arguments.of("hello@world!", "Test: Remove special characters from alphanumeric"),
                    Arguments.of("123 456!", "Test: Remove special characters from numbers"),
                    Arguments.of("!!!", "Test: String with only special characters")
            );
        }

        static Stream<Arguments> isPalindromeCases() {
            return Stream.of(
                    Arguments.of("A man a plan a canal Panama", "Test: Palindrome phrase with spaces and mixed case"),
                    Arguments.of("hello", "Test: Non-palindrome word"),
                    Arguments.of("abba", "Test: Simple palindrome word")
            );
        }

        static Stream<Arguments> isValidPalindromeCases() {
            return Stream.of(
                    Arguments.of("A man, a plan, a canal: Panama", "Test: Valid palindrome with special characters"),
                    Arguments.of("race a car", "Test: Non-palindrome phrase"),
                    Arguments.of(" ", "Test: Empty space as valid palindrome")
            );
        }
    }

    @Nested
    class Q3 {
        @ParameterizedTest(name = "{2}")
        @MethodSource("generatePrimesCases")
        public void testGeneratePrimes(int lower, int upper, String testName) {
            assertThat(mySolution.generatePrimes(lower, upper)).isEqualTo(scheme.generatePrimes(lower, upper));
        }

        static Stream<Arguments> generatePrimesCases() {
            return Stream.of(
                    Arguments.of(1, 10, "Test: Primes between 1 and 10"),
                    Arguments.of(10, 20, "Test: Primes between 10 and 20"),
                    Arguments.of(20, 20, "Test: No primes for single non-prime number"),
                    Arguments.of(0, 2, "Test: Primes including smallest prime number"),
                    Arguments.of(-10, 10, "Test: Negative lower bound")
            );
        }
    }
}
