package com.soul.annotation;

import java.lang.annotation.*;

/**
 * @author soulChun
 * @create 2018-12-17-11:32
 */
@Target(ElementType.TYPE)//你的注解作用在什么地方  TYPE代表作用在Class上
@Retention(RetentionPolicy.RUNTIME) //注解传递的存货周期
@Inherited //子类是否继承父类的RZBean   加代表继承  不加代表不继承
public @interface RZBean {

    String table();

    String from() default "rz";

}
