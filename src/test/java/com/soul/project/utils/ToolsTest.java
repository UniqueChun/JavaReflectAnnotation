package com.soul.project.utils;


import com.soul.project.domain.Dog;
import com.soul.project.domain.User;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author soulChun
 * @create 2018-12-17-16:37
 */
public class ToolsTest {
    @Test
    public void test03() throws  Exception{
        Class<?> clzz = Class.forName("com.soul.project.domain.User");
        Field field = clzz.getDeclaredField("birthday");
        System.out.println(Tools.getMethod(field,"get"));


    }

    @Test
    public void test02() throws  Exception{
        Class<?> clzz = Class.forName("com.soul.project.domain.User");
        Field field = clzz.getDeclaredField("birthday");
        System.out.println(Tools.getColumn(field));
    }



    @Test
    public void test01(){
        String tableUser = Tools.getTable(User.class);
        String tableDog = Tools.getTable(Dog.class);
        System.out.println(tableUser);
        System.out.println(tableDog);
    }
}
