package com.example.lijie.studySpringAnnotation.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * auther lijie  2019/3/21.
 */
@Component
public class BeanFactoryPostProcessor_2 implements BeanFactoryPostProcessor,Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("调用 BeanFactoryPostProcessor_2 ...");

        // 获取指定的 BeanDefinition
        BeanDefinition bd = beanFactory.getBeanDefinition("person");

        MutablePropertyValues pvs = bd.getPropertyValues();

        pvs.addPropertyValue("age",26);
    }

    @Override
    public int getOrder() {
        return 1;
    }

}