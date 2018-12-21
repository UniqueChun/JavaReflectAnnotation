package com.soul.project.utils;


import com.soul.project.annotation.RZBean;
import com.soul.project.annotation.RZField;
import java.lang.reflect.Field;

/**
 * @author soulChun
 * @create 2018-12-17-16:31
 */
public class Tools {
    /**
     根据字段获取到get/set
     type:get/set
     */
    public static String getMethod(Field field,String type){
        //name age
        String fieldName = field.getName();
        //Name Age
        String name = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
        return type + name ;
    }



    /**
     * 获取数据表的列名
     */
    public static String getColumn(Field field){

        String column = "";
        RZField rzField = field.getAnnotation(RZField.class);
        if(rzField != null){
            column = rzField.value().toLowerCase();
        }else {
            column = field.getName().toLowerCase();
        }
        return  column;
    }


    /**
        根据Class获取表名
     */
    public static String getTable(Class<?> clazz){
        String table = "";
        RZBean rzBean = clazz.getAnnotation(RZBean.class);
        if(rzBean != null){
            table = rzBean.value().toLowerCase();
        }else {
            table =clazz.getSimpleName().toLowerCase();
        }

        return table;
    }
}
