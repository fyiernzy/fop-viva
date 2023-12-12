package Viva2;

import Tools.*;
import static Tools.MyAssert.*;
import static Tools.TestcaseGenerator.*;

public class Q3Tester extends Tester {
    public Q3Tester(Scheme scheme, Solution solution) {
        super("Prime Number", scheme, solution);
    }

    public Q3Tester(Scheme scheme, Solution solution, boolean isShowErrorMessage) {
        super("Prime Number", scheme, solution, isShowErrorMessage);
    }

    @Override
    public boolean test() {
        boolean isPassed = true;
        int[][][] testCases = getTestCases();
        for (int i = 0; i < testCases.length; i++) {
            Log.logInfo("Test Case " + (i + 1) + ":");
            for (int j = 0; j < testCases[i].length; j++) {
                isPassed &= testPrimeNumberGenerator(testCases[i][j], "Test Case " + (i + 1) + "-" + (j + 1));
                Timer.sleep();
            }
        }
        return isPassed;
    }

    boolean testPrimeNumberGenerator(int[] testCase, String testName) {
        int[] expected = scheme.generatePrimes(testCase[0], testCase[1]);
        int[] actual = solution.generatePrimes(testCase[0], testCase[1]);
        return assertEquals(
                expected, actual, 
                new Info(testName, new String[][] { { "Test Case", testCase[0] + " " + testCase[1] } },
                        Formatter.arrayToString(expected), Formatter.arrayToString(actual)));
    }

    int[][][] getTestCases() {
        int[][][] testCases = new int[3][3][];
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++)
                testCases[i][j] = new int[] { randInt(-25, 25), randInt(25, 50) };
        }  
        return testCases;
    }
}
