/**
 * Created by lijie on 2017/6/18.
 */
package com.example.lijie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * auther lijie  2017/6/18.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("nihao!");

        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        Object testService = wac.getBean("testService");
        System.out.println(testService);

        return "resultPage";
    }
}