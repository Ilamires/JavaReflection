package com.Reflection.TestClasses;

/**
 * Alternative implementation of {@link SomeInterface} for testing purposes.
 * Returns different fixed values than {@link SomeImpl}.
 */
public class OtherImpl implements SomeInterface{
    /**
     * @return Always returns "B"
     */
    @Override
    public String doSomething() { return "B"; }

    /**
     * @return Always returns "E"
     */
    @Override
    public String doSomething2() { return "E"; }
}
