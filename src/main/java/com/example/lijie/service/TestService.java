package com.example.lijie.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * auther lijie  2018/5/9.
 */
@Service
public class TestService {

    @Transactional
    public void canTransaction(){
        System.out.println("执行了service中的代码................");
        System.out.println("执行了service中的代码................");
        System.out.println("执行了service中的代码................");
        System.out.println("执行了service中的代码................");
        System.out.println("执行了service中的代码................");
    }
}