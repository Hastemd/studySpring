package com.example.lijie.studySpringAnnotation.config;

import com.example.lijie.studySpringAnnotation.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * auther lijie  2019/1/25.
 */

@Configuration
//@ComponentScan(value="com.example.lijie.studySpringAnnotation")
//@ComponentScan value : 指定要扫描的包
@ComponentScan(value="com.example.lijie.studySpringAnnotation",includeFilters = {
        //@ComponentScan.Filter(type=FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})
    },useDefaultFilters=false
)
//includeFilters = Filter[] , 要先 useDefaultFilters = false
//excludeFilters = Filter[]
public class MainConfig {

    @Bean("person")
    public Person person1(){
        return new Person("iris", 18);
    }

}