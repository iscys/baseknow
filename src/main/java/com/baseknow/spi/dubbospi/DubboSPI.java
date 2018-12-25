package com.baseknow.spi.dubbospi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * dubbo spi 机制，需要引用dubbo的spi 注解标签
 */
@SPI
public interface DubboSPI {

    public void sayHello();
}
