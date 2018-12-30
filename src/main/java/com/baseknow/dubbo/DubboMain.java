package com.baseknow.dubbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboMain {

    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/dubbo.xml");
        Thread.sleep(10000000);

    }
}
