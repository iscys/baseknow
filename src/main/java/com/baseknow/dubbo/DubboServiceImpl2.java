package com.baseknow.dubbo;

public class DubboServiceImpl2 implements IdubboService {


    @Override
    public Object sayHello(String name, String age) {
        return 1/0;
    }

    @Override
    public String sayBye(Object name, String age) {
        return null;
    }


    public <T>T getTest(T classa){

        return classa;
    }

}
