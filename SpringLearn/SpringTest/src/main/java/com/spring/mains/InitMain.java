package com.spring.mains;

import com.spring.bean.Person;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by liuyong on 2016/3/9.
 */
public class InitMain {
    public static void main(String[] args) {
        //FileSystemXmlApplicationContext
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("PersonBean.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
    }
}
