package com.Reflection;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for automatic dependency injection through reflection.
 * <p>
 * Fields marked with this annotation will be automatically initialized
 * with instances of classes specified in the configuration file (`.properties`).
 * The field type must be an interface, and the implementation is defined in the configuration.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 * {@code
 * class Example {
 *     @AutoInjectable
 *     private SomeInterface dependency;
 * }
 * }
 * </pre>
 *
 * <p>
 * To work properly, the configuration file (e.g., `config.properties`)
 * must contain an entry in the format:
 * {@code fully.qualified.InterfaceName=fully.qualified.ImplementationClassName}
 * </p>
 *
 * @see Injector The dependency injector that uses this annotation.
 * @since 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}
