package Viva2;

import Tools.ErrorBook;

public class Main {
    public static void main(String[] args) {
        Scheme scheme = new Scheme();
        Solution solution = new Solution();

        boolean isShowErrorMessage = false;
        boolean[] isRunTest = new boolean[] {true, true, true};

        if(isRunTest[0])
            new Q1Tester(scheme, solution, isShowErrorMessage).run();
        if(isRunTest[1])
            new Q2Tester(scheme, solution, isShowErrorMessage).run();
        if(isRunTest[2])
            new Q3Tester(scheme, solution, isShowErrorMessage).run();

        ErrorBook book = ErrorBook.getBook();
        if(book.isAnyError())
            book.printRecords();
    }
}
