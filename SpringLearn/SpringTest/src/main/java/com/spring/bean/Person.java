package com.spring.bean;

import java.util.Date;

/**
 * Created by liuyong on 2016/3/9.
 */
public class Person {
    private String name;
    private int age;
    private Date birthday;

    public void init(){
        this.name = "tcliuyong";
        this.age = 12;
        this.birthday = new Date();
    }
    public void clearup(){
        this.name = "";
        this.birthday = null;
        this.age = 0;
    }
    public Person(){//使用BeanWrapper的时候最好加上

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

}
