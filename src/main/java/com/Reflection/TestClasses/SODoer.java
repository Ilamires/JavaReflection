package com.Reflection.TestClasses;

/**
 * Implementation of {@link SomeOtherInterface} that returns fixed value "C".
 * Used for dependency injection testing scenarios.
 */
public class SODoer implements SomeOtherInterface{
    /**
     * Returns the fixed string value for testing purposes.
     * @return Always returns "C"
     */
    @Override
    public String doSomeOther() { return "C"; }
}
