package com.soul.Introspector;

import com.soul.reflection.Student;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author soulChun
 * @create 2018-12-17-09:55
 */
public class IntrospectorApp {

    @Test
    public void test01() throws Exception{
        Student student = new Student();

        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("age",Student.class);
        Method setMethod = propertyDescriptor.getWriteMethod();
        setMethod.invoke(student,30);
//        System.out.println(student);
        System.out.println(student.getAge());


        Method getMethod = propertyDescriptor.getReadMethod();
        System.out.println("ReadMethod " + getMethod.invoke(student));


        //获取属性
//        BeanInfo beanInfo =  Introspector.getBeanInfo(Student.class,Object.class);
//        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
//        for (PropertyDescriptor propertyDescriptor : propertyDescriptors){
//            System.out.println(propertyDescriptor.getName());
//        }


    }
}
