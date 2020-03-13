package com.baseknow.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class DubboMain {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/dubbo.xml");
        ((ClassPathXmlApplicationContext) context).start();
        Thread.sleep(10000000);


    }
}
