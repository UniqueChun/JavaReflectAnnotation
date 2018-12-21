package com.soul;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author soulChun
 * @create 2018-12-16-23:24
 */
public class ReflectionDemo {
    @Test
    public void test()  throws  Exception{

        List<String> tearchs = new ArrayList<>();
        tearchs.add("苍老师");
        tearchs.add("泷泽萝拉老师");
//        list.add(234);//必须把非字符串的字符放进去，且不能修改泛型的类型  此时可以利用反射解决

        Class<?> clazz = tearchs.getClass();
//        System.out.println(clazz);

        //反射可以擦除泛型固定的类型
        Method method = clazz.getDeclaredMethod("add", Object.class);
        method.invoke(tearchs,234);
        method.invoke(tearchs,456);

        for (Object object : tearchs){
            System.out.println(object);
        }


    }
}
