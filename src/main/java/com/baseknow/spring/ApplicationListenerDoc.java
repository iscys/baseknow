package com.baseknow.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerDoc implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //在spring容器加载完之后进行触发此操作
        if(ContextRefreshedEvent.class.getName().equals(event.getClass())){

        }
    }
}
