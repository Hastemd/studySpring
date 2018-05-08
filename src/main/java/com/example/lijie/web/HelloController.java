/**
 * Created by lijie on 2017/6/18.
 */
package com.example.lijie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * auther lijie  2017/6/18.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        System.out.println("nihao!");
        return "resultPage";
    }
}