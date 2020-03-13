package com.baseknow.utils;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理模版通用方法,接口代理
 * 具体功能再进行增加
 * @author iscys
 *
 */
public class JdkProxy implements InvocationHandler ,Serializable {

	private static final long serialVersionUID = -4467164789570764661L;


	@SuppressWarnings("unchecked")
	public static <T> T newProxy(Class<T> myInterfaces) {
		ClassLoader classLoader = myInterfaces.getClassLoader();
		Class<?>[] interfaces =new Class[]{myInterfaces};
		JdkProxy proxy =new JdkProxy();
		return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		String name = method.getName();

		return name;
	}

}
