package com.InjectorTest;
import com.Reflection.TestClasses.SomeBean;
import org.junit.Test;
import org.junit.Assert;
import com.Reflection.Injector;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class InjectorTest {

    @Test
    public void InjectorInjectTest() throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        boolean result;

        SomeBean sb = (new Injector("injector.properties")).inject(new SomeBean());
        result = sb.foo().equals("AC");
        result = result && sb.foo2().equals("DC");
        Assert.assertTrue(result);

        SomeBean sb2 = (new Injector("injector2.properties")).inject(new SomeBean());
        result = sb2.foo().equals("BC");
        result = result && sb2.foo2().equals("EC");
        Assert.assertTrue(result);
    }
}
