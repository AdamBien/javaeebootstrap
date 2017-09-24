package com.airhacks.di.presentation;

import java.lang.reflect.Method;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * @author airhacks.com
 */
public class MethodCallLogger {

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        Method method = ic.getMethod();
        long start = System.nanoTime();
        try {
            return ic.proceed();
        } finally {
            System.out.println("Method: " + method + " invoked in " + (System.nanoTime() - start) + " seconds");
        }
    }

}
