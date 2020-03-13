package com.baseknow.dubbo;

public class DubboServiceImpl implements IdubboService {


    @Override
    public Object sayHello(String name, String age) {
        return "impl1";
    }

    @Override
    public String sayBye(Object name, String age) {
        return null;
    }
}
