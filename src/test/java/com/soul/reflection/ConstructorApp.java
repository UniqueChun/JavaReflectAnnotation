package com.soul.reflection;

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.Constructor;

/**
 * @author soulChun
 * @create 2018-12-16-23:01
 */
public class ConstructorApp {
    @Test

    public void test02() throws Exception {
        Class<?> clazz = Class.forName("com.soul.reflection.Student");

        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class,String.class,Integer.class);
        Object object = constructor.newInstance("soul","男",20);

        System.out.println(object);


    }


    @Test
    public void test01() throws Exception {

        Class<?> clazz = Class.forName("com.soul.reflection.Student");

        //获取所有构造方法的名字
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {

            System.out.println(constructor.getName());

            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("构造方法参数的类型" + parameterType);
            }
        }


    }
}
