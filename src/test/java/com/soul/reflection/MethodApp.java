package com.soul.reflection;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author soulChun
 * @create 2018-12-16-22:41
 */
public class MethodApp {
    @Test
    public void test01() throws  Exception{
        Class<?> clazz = Class.forName("com.soul.reflection.Student");

        Object object = clazz.newInstance();
        Method setMethod = clazz.getDeclaredMethod("setSex", String.class);
        setMethod.invoke(object,"男2");

        Method getMethod = clazz.getDeclaredMethod("getSex");
        getMethod.invoke(object);
    }
}
