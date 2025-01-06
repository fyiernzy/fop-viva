package com.fyiernzy.suite;

import com.fyiernzy.Solution;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2TestSuite extends AbstractTestSuite {
    public Q2TestSuite(Solution scheme, Solution solution) {
        super(scheme, solution);
    }

    @Override
    public void runTests() {
        testRemoveSpecialCharacters();
        testIsPalindrome();
        testIsValidPalindrome();
    }

    void testRemoveSpecialCharacters() {
        removeSpecialCharactersCases().forEach(input -> {
            assertThat(solution.removeSpecialCharacters(input)).isEqualTo(scheme.removeSpecialCharacters(input));
        });
    }

    void testIsPalindrome() {
        isPalindromeCases().forEach(input -> {
            assertThat(solution.isPalindrome(input)).isEqualTo(scheme.isPalindrome(input));
        });
    }

    void testIsValidPalindrome() {
        isValidPalindromeCases().forEach(input -> {
            assertThat(solution.isValidPalindrome(input)).isEqualTo(scheme.isValidPalindrome(input));
        });
    }

    List<String> removeSpecialCharactersCases() {
        return List.of("hello@world!", "123 456!", "!!!");
    }

    List<String> isPalindromeCases() {
        return List.of("A man a plan a canal Panama", "hello", "abba");
    }

    List<String> isValidPalindromeCases() {
        return List.of("A man, a plan, a canal: Panama", "race a car", " ");
    }
}