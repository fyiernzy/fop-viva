package Tools;

import java.util.*;

public class Formatter {
    public static String color(String message, String color) {
        return String.format("%s%s%s", color, message, FontStyle.RESET);
    }

    public static String truncate(double value) {
        return String.format("%10.4f", value);
    }

    public static String addNewLines(String string) {
        return String.format("\n%s\n", string);
    }

    public static String matrixToString(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            sb.append("  {");
            for (int i = 0; i <  row.length; i++)
                sb.append(truncate(row[i]) + ((i == row.length - 1) ? "" :", "));
            sb.append("}\n");
        }
        return sb.toString();
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            sb.append("  {");
            for (int i = 0; i <  row.length; i++)
                sb.append(truncate(row[i]) + ((i == row.length - 1) ? "" :", "));
            sb.append("}\n");
        }
        return sb.toString();
    }

    public static String arrayToString(double[] array) {
        return Arrays.toString(array);
    }

    public static String arrayToString(int[] array) {
        return Arrays.toString(array);
    }
}
