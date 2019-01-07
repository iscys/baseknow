package com.baseknow.netty;

import com.baseknow.netty.service.Invocations;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyNetty implements InvocationHandler {

    public static NettyClient client = new NettyClient("127.0.0.1", 9077);

    public <T>T getProxy(Class<T> interfaces){
        ClassLoader classLoader = interfaces.getClassLoader();
        Class<?>[] interfaces1 =new Class[]{interfaces};
        return (T) Proxy.newProxyInstance(classLoader, interfaces1, this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(client, args);
        }
        if ("toString".equals(methodName) && parameterTypes.length == 0) {
            return client.toString();
        }
        if ("hashCode".equals(methodName) && parameterTypes.length == 0) {
            return client.hashCode();
        }
        if ("equals".equals(methodName) && parameterTypes.length == 1) {
            return client.equals(args[0]);
        }
        return client.write(new Invocations(methodName,args)).get();
    }
}
