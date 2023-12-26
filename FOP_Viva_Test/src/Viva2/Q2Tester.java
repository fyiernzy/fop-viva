package Viva2;

import static Tools.MyAssert.*;

import java.util.List;

import Tools.*;

public class Q2Tester extends Tester {

    Q2Tester(Scheme scheme, Solution solution) {
        super("Palindromic String", scheme, solution);
    }

    Q2Tester(Scheme scheme, Solution solution, boolean isShowErrorMessage) {
        super("Palindromic String", scheme, solution, isShowErrorMessage);
    }

    @Override
    public boolean test() {
        boolean isPassed = true;
        List<String> testCases = getTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            isPassed &= testPalindrome(testCases.get(i), "Test Case " + (i + 1));
            isPassed &= testValidPalindrome(testCases.get(i), "Test Case (VP) " + (i + 1));
            Timer.sleep();
        }
        return isPassed;
    }

    boolean testPalindrome(String testCase, String testName) {
        boolean expected = scheme.isPalindrome(testCase);
        boolean actual = solution.isPalindrome(testCase);
        return assertEquals(expected, actual, new Info(testName, new String[][] {{"Test Case", testCase}}, expected + "", actual + ""));
    }

    boolean testValidPalindrome(String testCase, String testName) {
        boolean expected = scheme.isValidPalindrome(testCase);
        boolean actual = solution.isValidPalindrome(testCase);
        return assertEquals(expected, actual, new Info(testName, new String[][] {{"Test Case", testCase}}, expected + "", actual + ""));
    }

    public List<String> getTestCases() {
        return List.of("1221", "Able was I ere I saw Elba", "Madam I'm Adam", "Never odd or even",
                "Doc note I dissent A fast never prevents a fatness I diet on cod", "Able was I, ere I saw Elba!");
    }

}
