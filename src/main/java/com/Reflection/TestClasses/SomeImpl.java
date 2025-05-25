package com.Reflection.TestClasses;

/**
 * Implementation of SomeInterface returning fixed values.
 * Used for dependency injection testing.
 */
public class SomeImpl implements SomeInterface {
    /**
     * @return Always returns "A"
     */
    @Override
    public String doSomething() { return "A"; }

    /**
     * @return Always returns "D"
     */
    @Override
    public String doSomething2() { return "D"; }
}
