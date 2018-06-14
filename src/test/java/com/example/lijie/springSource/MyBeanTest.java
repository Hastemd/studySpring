package com.example.lijie.springSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MyBeanTest {

    /**
     * @Description 这一段代码,执行了太多的逻辑~ , 是的哇,要好好看的~
     * @Author 李杰 lijie@ane56.com
     * @Date 2018/6/8 下午10:18
     */
    @Test
    public void getTestStr() {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory bf = new XmlBeanFactory(resource);
        //BeanFactory bf = XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        MyBean myBean = (MyBean)bf.getBean("myBean");
        Assert.assertEquals("testStr",myBean.getTestStr());
    }
}