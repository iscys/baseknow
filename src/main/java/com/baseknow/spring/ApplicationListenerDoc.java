package com.baseknow.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationListenerDoc implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event);
        //在spring容器加载完之后进行触发此操作
        if(ContextRefreshedEvent.class.getName().equals(event.getClass().getName())){
            System.err.println(event);
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:springTest/applicationListener.xml");

        context.publishEvent(new ApplicationEventDoc("aaa"));
    }
}
