package com.soul.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author soulChun
 * @create 2018-12-17-11:30
 * Annotaion 注解  Java 1.5引入
 */
public class AnnotationApp {


    @Test
    public void test03() throws Exception {
        //在RZBean头上加了@Inherited  那么子类Dog就可以集成父类Animal的RZBean 否则打印出来是空
//        Class<?> clazz = Class.forName("com.soul.annotation.Dog");

        Class<?> clazz = Class.forName("com.soul.annotation.Animal");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }


    @Test
    public void test02() throws Exception {
        Class<?> clazz = Class.forName("com.soul.annotation.Animal");
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            RZField rzField = field.getAnnotation(RZField.class);
            //必须判断rzField是否为空 否则报空指针异常
            if (rzField != null) {
                System.out.println(field.getName() + " : " + rzField.value());
            }
        }
    }

    @Test
    public void test01() throws Exception {
        Class<?> clazz = Class.forName("com.soul.annotation.Animal");

        System.out.println(clazz.isAnnotationPresent(RZBean.class));

        RZBean rzBean = clazz.getAnnotation(RZBean.class);
        System.out.println(rzBean.table() + " : " + rzBean.from());
        System.out.println(rzBean.annotationType());

    }

}
