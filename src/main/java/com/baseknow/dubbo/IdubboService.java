package com.baseknow.dubbo;

import com.alibaba.dubbo.common.extension.Adaptive;

public interface IdubboService {

    @Adaptive
    public Object sayHello(String name,String age);
    @Adaptive
    public String sayBye(Object name,String age);
}
