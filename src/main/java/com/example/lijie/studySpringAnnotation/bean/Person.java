package com.example.lijie.studySpringAnnotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * auther lijie  2019/1/25.
 */
@PropertySource("classpath:application.properties")
@Component
public class Person {

    @Value("${person.name}")
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(Integer age) {
        System.out.println("调用有参构造方法 : Person(Integer age)");
        this.age = age;
    }

    public Person() {
        System.out.println("调用无参构造方法...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}