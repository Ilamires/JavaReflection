package com.Reflection;

import com.Reflection.TestClasses.SomeBean;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        SomeBean sb = (new Injector("injector.properties")).inject(new SomeBean());
        System.out.println(sb.foo());
    }
}