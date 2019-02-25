package com.baseknow.spi.dubbospi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.lang.reflect.Constructor;

public class DubboMain {
  public   DubboMain(String a){
        System.out.println(a);
    }

    public static void main(String[] args)throws Exception {
        ExtensionLoader<DubboSPI> extensionLoader =
                ExtensionLoader.getExtensionLoader(DubboSPI.class);
        DubboSPI optimusPrime = extensionLoader.getExtension("DubboSPI");
        optimusPrime.sayHello();

        Class<DubboMain> dubboMainClass = DubboMain.class;
        Constructor<DubboMain> constructor = dubboMainClass.getConstructor(String.class);
        constructor.newInstance("rr");

    }
}
