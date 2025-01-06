package com.fyiernzy.suite;

import com.fyiernzy.Solution;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractTestSuite {
    protected final Solution solution;
    protected final Solution scheme;

    public abstract void runTests();
}
