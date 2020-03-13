package com.baseknow.spi;

public class OptimusPrime implements Robot {

    static {
        System.out.println("************************************");
    }

    public String sayHello() {
        System.out.println("test spi 服务发现机制");
        return "哈哈哈";
    }

}
