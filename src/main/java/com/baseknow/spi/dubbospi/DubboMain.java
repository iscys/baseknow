package com.baseknow.spi.dubbospi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class DubboMain {


    public static void main(String[] args) {
        ExtensionLoader<DubboSPI> extensionLoader =
                ExtensionLoader.getExtensionLoader(DubboSPI.class);
        DubboSPI optimusPrime = extensionLoader.getExtension("DubboSPI");
        optimusPrime.sayHello();

    }
}
