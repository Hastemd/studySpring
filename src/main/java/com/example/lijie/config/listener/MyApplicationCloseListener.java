package com.example.lijie.config.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * auther lijie  2018/10/29.
 */
public class MyApplicationCloseListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("spring容器关闭了... : " + event.toString());
    }
}