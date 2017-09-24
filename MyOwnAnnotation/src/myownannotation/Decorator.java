/*
 */
package myownannotation;

import java.lang.reflect.Proxy;

/**
 *
 * @author adam-bien.com
 */
public class Decorator {

    public static Object decorate(Object toDecorate) {
        Class<? extends Object> clazz = toDecorate.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new LoggingAspect(toDecorate));
    }

}
