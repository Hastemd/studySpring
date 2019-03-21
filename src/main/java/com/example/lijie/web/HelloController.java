/**
 * Created by lijie on 2017/6/18.
 */
package com.example.lijie.web;

import com.example.lijie.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * auther lijie  2017/6/18.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private TestService testService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("nihao!");

        //WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        //Object testService = wac.getBean("testService");
        //System.out.println(testService);
        testService.canTransaction();

        return "resultPage";
    }


    @RequestMapping("/testGet")
    @ResponseBody
    public String testGetMethod(HttpServletRequest request){
        System.out.println(request.getContextPath());
        System.out.println(request.getMethod());
        System.out.println(request.getQueryString());
        try {
            System.out.println(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(request.getParameterMap());
        System.out.println(request.getParameterNames());
        System.out.println(request.getProtocol());
        return "testGetMethod";
    }
}