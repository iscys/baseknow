package com.baseknow.spring;

import com.baseknow.dubbo.IdubboService;
import com.baseknow.utils.JdkProxy;
import org.springframework.beans.factory.FactoryBean;

public class FactoryBeanIm implements FactoryBean {

    private Class interfaces = IdubboService.class;

    @Override
    public Object getObject() throws Exception {
        return JdkProxy.newProxy(interfaces);
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }



}
