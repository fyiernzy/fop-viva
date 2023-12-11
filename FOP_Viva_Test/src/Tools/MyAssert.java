package Tools;

import static org.junit.Assert.*;
import org.junit.Assert;

import java.util.function.BiConsumer;

public class MyAssert {
    public static final double DEFAULT_PRECISION = 0.01;

    private static <T> boolean assertWithConsumer(BiConsumer<T, T> consumer, T expected, T actual, Info info) {
        try {
            consumer.accept(expected, actual);
            Log.logPass(info.getTestName());
            return true;
        } catch (AssertionError e) {
            Log.logFail(info.getTestName());
            ErrorBook.getBook().addRecord(info);
            return false;
        }
    }

    public static boolean assertEquals(double[] expected, double[] actual, double precision, Info info) {
        return assertWithConsumer((a, b) -> assertArrayEquals((double[]) a, (double[]) b, precision), expected, actual, info);
    }

    public static boolean assertEquals(double[] expected, double[] actual, Info info) {
        return assertEquals(expected, actual, DEFAULT_PRECISION, info);
    }

     public static boolean assertEquals(double[][] expected, double[][] actual, Info info) {
        return assertWithConsumer(Assert::assertArrayEquals, expected, actual, info);
    }

    public static boolean assertEquals(int[] expected, int[] actual, Info info) {
        return assertWithConsumer(Assert::assertArrayEquals, expected, actual, info);
    }

    public static boolean assertEquals(boolean expected, boolean actual, Info info) {
        return assertWithConsumer(Assert::assertEquals, expected, actual, info);
    }

    public static boolean assertEquals(String expected, String actual, Info info) {
        return assertWithConsumer(Assert::assertEquals, expected, actual, info);
    }
}
