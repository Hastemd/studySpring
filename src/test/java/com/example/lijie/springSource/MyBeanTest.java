package com.example.lijie.springSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyBeanTest {

    @Test
    public void getTestStr() {

        System.out.println("ok");
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory bf = new XmlBeanFactory(resource);
        //BeanFactory bf = XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyBean myBean = (MyBean)bf.getBean("myBean");
        Assert.assertEquals("testStr1",myBean.getTestStr());
    }
}