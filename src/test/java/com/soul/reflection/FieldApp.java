package com.soul.reflection;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author soulChun
 * @create 2018-12-16-22:09
 */
public class FieldApp   {

    @Test
    public void test02() throws Exception{
        Class<?> clazz = Class.forName("com.soul.reflection.Student");
        Field field = clazz.getDeclaredField("sex");

        Student student = (Student) clazz.newInstance();

        //设置对private sex 属性有访问权限
        if(!field.isAccessible()){
            field.setAccessible(true);
        }

        field.set(student,"男");
        System.out.println(student);

        System.out.println("---------------");
        String sex = (String) field.get(student);
        System.out.println(sex);

    }
    @Test
    public void test01() throws Exception {
        Class<?> clazz = Class.forName("com.soul.reflection.Student");

        Field[] fields = clazz.getDeclaredFields();

        for(Field field:fields){
            System.out.println(field.getType() + " : " + field.getName());
        }

        System.out.println("----------");
        Field field = clazz.getDeclaredField("sex");
        System.out.println(field.getType() + " : " + field.getName());
        System.out.println("-------------[");

    }
}
