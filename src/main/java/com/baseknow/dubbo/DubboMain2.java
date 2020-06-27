package com.baseknow.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboMain2 {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/dubbo2.xml");
        ((ClassPathXmlApplicationContext) context).start();
        Thread.sleep(10000000);


    }
}
