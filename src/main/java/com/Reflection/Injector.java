package com.Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Injector {
    private Properties properties;

    public Injector(String fileName) {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public <T> T inject(T object) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> objectClass = object.getClass();
        for (Field field : objectClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String implementationClassName = properties.getProperty(field.getType().getName());
                if (implementationClassName == null) {
                    throw new RuntimeException("No implementation for " + field.getType().getName());
                }
                Class<?> implementationClass = Class.forName(implementationClassName);
                field.setAccessible(true);
                field.set(object, implementationClass.getDeclaredConstructor().newInstance());
            }
        }
        return object;
    }
}
