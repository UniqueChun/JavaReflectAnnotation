package com.soul.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

/**
 * @author soulChun
 * @create 2018-12-16-21:23
 * <p>
 * 获取Class的几种方式：
 * 1）Class.forName
 * 2)obj.getClass
 * 3) class.class
 */
public class ReflctionApp {

    @Test
    public void test04() {
        Class<?> clazz = Child.class;
        System.out.println(clazz);


        clazz = clazz.getSuperclass();
        System.out.println(clazz);

        //Object
        clazz = clazz.getSuperclass();
        System.out.println(clazz);


        //null
        clazz = clazz.getSuperclass();
        System.out.println(clazz);

    }


    @Test
    public void test03() {
        System.out.println(Integer.class);
        System.out.println(Integer.TYPE);
    }


    @Test
    public void test02() {
        String name = "soul";
        Class<?> clazz = name.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------------");

        Class<?> clazz1 = String.class;
        Method[] methods1 = clazz1.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
    }

    @Test
    public void test01() throws Exception {
        Class<?> clazz = Class.forName("java.lang.Object");
//        获取所有(public / private .....)
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("````````````````````");
        //只获取到public的
        methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}

class Parent {

}

class Child extends Parent {

}