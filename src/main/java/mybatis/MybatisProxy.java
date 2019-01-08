package mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MybatisProxy implements InvocationHandler {

    public static <T> T getProxy(Class<T> interfaceClass){

        ClassLoader classLoader = interfaceClass.getClassLoader();
        Class<?>[] interfaces =new Class[]{interfaceClass};
        MybatisProxy proxy = new MybatisProxy();
        return (T)Proxy.newProxyInstance(classLoader,interfaces,proxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        return "1";
    }
}
