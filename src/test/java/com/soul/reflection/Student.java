package com.soul.reflection;

/**
 * @author soulChun
 * @create 2018-12-16-22:09
 */
public class Student {
    private String name;
    private String sex;
    private Integer age;

    public Student() {
        System.out.println("无参");
    }

    public Student(String name, String sex, Integer age) {
        System.out.println("有参");
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        System.out.println("Student : getSex = " + sex);
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("Student : setSex = " + sex);
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
