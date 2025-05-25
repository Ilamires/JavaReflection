package com.Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * A dependency injector that uses reflection to automatically inject implementations
 * into fields marked with {@link AutoInjectable} annotation.
 * <p>
 * The injector reads interface-to-implementation mappings from a properties file
 * and creates appropriate instances at runtime.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 * {@code
 * // config.properties content:
 * // com.example.Service=com.example.ServiceImpl
 *
 * Injector injector = new Injector("config.properties");
 * MyClass instance = injector.inject(new MyClass());
 * }
 * </pre>
 *
 * @see AutoInjectable Annotation marking fields for automatic injection
 */
public class Injector {
    private final Properties properties;

    /**
     * Creates a new Injector instance with configuration from the specified file.
     *
     * @param fileName the properties file name (should be in classpath)
     * @throws RuntimeException if the properties file cannot be loaded
     */
    public Injector(String fileName) {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    /**
     * Performs dependency injection on the specified object.
     * <p>
     * Scans all fields of the object, and for each field marked with {@link AutoInjectable},
     * creates and injects an instance of the implementation class specified in the properties file.
     * </p>
     *
     * @param <T> the type of the object to inject dependencies into
     * @param object the target object for dependency injection
     * @return the same object with dependencies injected
     * @throws ClassNotFoundException if implementation class cannot be found
     * @throws NoSuchMethodException if implementation class has no default constructor
     * @throws InvocationTargetException if the constructor throws an exception
     * @throws InstantiationException if the implementation class is abstract
     * @throws IllegalAccessException if constructor is not accessible
     * @throws RuntimeException if no implementation is configured for a required interface
     */
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
