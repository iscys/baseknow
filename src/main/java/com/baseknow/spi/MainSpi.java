package com.baseknow.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * JAVA SPI 机制：服务发现机制
 * 在META-INF/services 下创建 接口的全限名的文件com.baseknow.spi.Robot
 * 在文件中写入接口实现类的全限名；
 * 这样就可以进行方法的调用
 */
public class MainSpi {

    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");

        Iterator<Robot> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            Robot next = iterator.next();
            next.sayHello();
        }

    }
}
