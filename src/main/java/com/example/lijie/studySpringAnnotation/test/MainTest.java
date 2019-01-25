package com.example.lijie.studySpringAnnotation.test;

import com.example.lijie.studySpringAnnotation.bean.Person;
import com.example.lijie.studySpringAnnotation.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * auther lijie  2019/1/25.
 */
public class MainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for(String name : beanNamesForType){
            System.out.println(name);
        }

    }
}