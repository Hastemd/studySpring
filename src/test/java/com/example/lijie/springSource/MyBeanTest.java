package com.example.lijie.springSource;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {

    /**
     * @Description 这一段代码,执行了太多的逻辑~ , 是的哇,要好好看的~
     * @Author 李杰 lijie@ane56.com
     * @Date 2018/6/8 下午10:18
     */
    @Test
    public void getTestStr() {
        //Resource resource = new ClassPathResource("applicationContext.xml");
        //BeanFactory bf = new XmlBeanFactory(resource);
        ////BeanFactory bf = XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //MyBean myBean = (MyBean)bf.getBean("myBean");
        //Assert.assertEquals("testStr",myBean.getTestStr());
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean myBean = (MyBean)applicationContext.getBean("myBean");
        Assert.assertEquals("testStr",myBean.getTestStr());
    }
}