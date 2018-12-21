package com.soul.Introspector;

import com.soul.reflection.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author soulChun
 * @create 2018-12-17-10:15
 */
public class BeanUtilsApp {

    @Test
    public void test02(){

    }



    //xxxx?name=abc&password=123
    //Date 必须手工转换
    @Test
    public void test01() throws  Exception{
        Student student = new Student();
        BeanUtils.setProperty(student,"name","soul");

        System.out.println(student);


        System.out.println("1---------------");
        Map<String,Object> map = new HashMap<>();
        map.put("name","Bob");
        map.put("sex","男");
        map.put("age",20);
        BeanUtils.populate(student,map);
        System.out.println(student);
    }
}
