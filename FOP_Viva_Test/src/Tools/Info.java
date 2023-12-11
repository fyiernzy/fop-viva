package Tools;

import static Tools.Formatter.*;

public class Info {

    String testName;
    String[][] testCases;
    String expected;
    String actual;

    public Info(String testName, String[][] testCases, String expected, String actual) {
        this.testName = testName;
        this.testCases = testCases;
        this.expected = expected;
        this.actual = actual;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n", 
                    color(testName, FontStyle.YELLOW), 
                    testCaseString(), 
                    color("Expected\n", FontStyle.YELLOW) + expected, 
                    color("Actual\n", FontStyle.YELLOW) + actual);
    }

    public String testCaseString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCases.length; i++) {
            sb.append(String.format("%s\n%s\n", testCases[i][0], testCases[i][1]));
        }
        return sb.toString();
    }

    public String getTestName() {
        return testName;
    }
}
