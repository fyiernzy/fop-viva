package Viva2;

import Tools.Log;

public abstract class Tester {
    protected String name;
    protected Scheme scheme;
    protected Solution solution;
    protected boolean isShowErrorMessage = false;

    Tester(String name, Scheme scheme, Solution solution) {
        this(name, scheme, solution, false);
    }

    Tester(String name, Scheme scheme, Solution solution, boolean isShowErrorMessage) {
        this.name = name;
        this.scheme = scheme;
        this.solution = solution;
        this.isShowErrorMessage = isShowErrorMessage;
    }

    public void run() {
        Log.logInfo(String.format("TEST - %s\n", name));
        Log.logConclusion(test());
    }

    protected abstract boolean test();

}
