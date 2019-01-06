package com.baseknow.netty;

import com.baseknow.netty.service.DefaultNettyFuture;
import com.baseknow.netty.service.Invocations;
import com.baseknow.netty.service.ResultResponse;
import com.baseknow.spi.Robot;


public class NettyDoc {

    public static void main(String[] args)throws Exception {
       // NettyClient client = new NettyClient("127.0.0.1", 9077);

        ProxyNetty proxy =new ProxyNetty();
        Robot proxy1 = proxy.getProxy(Robot.class);
        String s = proxy1.sayHello();
        System.err.println(s);


    }




}



