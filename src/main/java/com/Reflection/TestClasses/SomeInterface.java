package com.Reflection.TestClasses;

/**
 * Test interface for dependency injection demo.
 * Defines two simple methods for implementations to provide.
 */
public interface SomeInterface {
    /**
     * Performs the primary operation defined by this interface.
     *
     * @return a string result representing the operation's output
     */
    public String doSomething();


    /**
     * Performs a secondary operation defined by this interface.
     *
     * @return a string result representing the secondary operation's output
     */
    public String doSomething2();
}
