package com.baseknow.utils;

import com.baseknow.dubbo.IdubboService;

import java.lang.reflect.Proxy;

public class TestuUtils {


    public static void main(String[] args) {

        TestuUtils w =new TestuUtils();
        IdubboService gethh1 = w.gethh(IdubboService.class);
        Object o = gethh1.sayHello("qwe", "qw");

    }

    public <T> T gethh(Class<T> tClass){

        return  JdkProxy.newProxy(tClass);
    }
}
