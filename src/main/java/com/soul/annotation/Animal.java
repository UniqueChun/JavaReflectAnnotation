package com.soul.annotation;

/**
 * @author soulChun
 * @create 2018-12-17-11:35
 */
@RZBean(table = "tb_animal", from = "soul")
public class Animal {

    private Integer id ;
    private String name;

    //gender代表tb_animal表中的字段名
    @RZField(value = "gender")
    private String sex;

    public Animal() {
    }

    public Animal(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
