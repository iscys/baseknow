package com.baseknow.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实现FactoryBean 的bean，将会被作为一个对象的工厂，
 * 不会直接的作为bean 的实例暴露在外边，而是通过getObject 方法
 * 进行对象的引用，也就是说这个对象的实例是通过getObject 方法返回的
 * @author cys
 *
 */
public class BeanFactoryDoc implements FactoryBean {
	
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:springTest/my.xml");
		
		Object bean = app.getBean("beanFactory");
		//返回的是1 ，并没有返回BeanFactoryDoc 的对象实例；
		System.out.println(bean);
	}

	@Override
	public Object getObject() throws Exception {
		//实际返回的对象
		return "1";
	}

	@Override
	public Class getObjectType() {
		//返回的对象类型
		return "1".getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	

}
