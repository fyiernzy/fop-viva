package Tools;

public class Log {
    final static String DELIMITER = "-".repeat(8) + ">";
    final static String PASS_MESSAGE = "PASS";
    final static String FAIL_MESSAGE = "FAIL";
    final static String START_DELIMITER = "\n" + ">".repeat(20);
    final static String END_DELIMITER = "<".repeat(20) + "\n";

    final static String FORMAT = "   - %-15s%s %s %s%s";

    private static void log(String testName, String color, String message) {
        System.out.println(String.format(FORMAT, testName, DELIMITER, color, message, FontStyle.RESET));
    }

    public static void logPass(String testName) {
        log(testName, FontStyle.GREEN, PASS_MESSAGE);
    }

    public static void logFail(String testName) {
        log(testName, FontStyle.RED, FAIL_MESSAGE);
    }

    public static void logColor(String message, String color) {
        System.out.println(Formatter.color(message, color));
    }

    public static void logInfo(String message) {
        logColor(message, FontStyle.YELLOW);
    }

    public static void logConclusion(boolean passed) {
        if (passed) {
            logColor("\nALL TESTS PASSED!\n\n", FontStyle.GREEN);
        } else {
            logColor("\nSOME TESTS FAILED!\n\n", FontStyle.RED);
        }
    }

    public static void logErrorMessage(String errorMessage) {
        logColor(START_DELIMITER, FontStyle.RED);
        System.out.println(errorMessage);
        logColor(END_DELIMITER, FontStyle.RED);
    }

}
