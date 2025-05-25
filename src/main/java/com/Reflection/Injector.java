package com.Reflection;

import java.io.FileInputStream;
import java.io.IOException;
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
}
