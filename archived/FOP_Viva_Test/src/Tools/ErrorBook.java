package Tools;

import java.util.*;

public class ErrorBook {
    private static final ErrorBook BOOK = new ErrorBook();
    private List<Info> records = new ArrayList<>();

    private ErrorBook() {
    }

    public static ErrorBook getBook() {
        return BOOK;
    }

    public void addRecord(Info info) {
        records.add(info);
    }

    public boolean isAnyError() {
        return records.size() > 0;
    }

    public void printRecords() {
        System.out.println("Records:");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }

    }

}
