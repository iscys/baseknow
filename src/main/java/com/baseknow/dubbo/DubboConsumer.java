package com.baseknow.dubbo;

import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.TreeMap;

public class DubboConsumer {

    public static void main(String[] args) throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo/dubboConsumer.xml");
        ((ClassPathXmlApplicationContext) context).start();
        IdubboService dubboService = (IdubboService)context.getBean("dubboService");

        System.out.println(dubboService.sayHello("ss","12"));



    }






}
