/**
 * Created by lijie on 2017/6/18.
 */
package com.example.lijie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * auther lijie  2017/6/18.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
//    @ResponseBody
    public String hello(@RequestParam(defaultValue="world") String userName , Model model){
//        model.addAttribute("message","Hello from the Controller");
        model.addAttribute("message" , "Hello, " + userName);
        return "resultPage";
    }
}