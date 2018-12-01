package com.baseknow.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baseknow.testclass.BeanDefinitionClass02;

/**
 * 主要进行BeanDefinition 的一些常规以及特性的操作
 * @author iscys
 *
 */
public class BeanDefinationDoc implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//定义一个bean 的容器
		GenericBeanDefinition gener =new GenericBeanDefinition();
		//设置bean class
		gener.setBeanClass(BeanDefinitionClass02.class);
		//为类中属性赋值
		gener.getPropertyValues().addPropertyValue("name", "cys");
		//我们还可以设置自动注入，在Spring加载的时候，将Spring 容器中存在的对象自动注入到类中的属性中
		/**
		 * 比如：
		 * 我在Spring 定义了 
		 * <bean calss="com.baseknow.testclass.TestClass">
		 * 然后我在这里设置gener.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		 * 之后，
		 * 在Spring加载的时候，如果我这个类中有TestClass 的属性，并且有set方法，就会自动注入到
		 * 我的类中；
		 */
		gener.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
		/**
		 * 将定义的bean 注册到Spring 容器中，被Spring 管理
		 */
		registry.registerBeanDefinition("testBefinition", gener);
	}
	
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:springTest/beandefiniition.xml");
		BeanDefinitionClass02 bean = (BeanDefinitionClass02) app.getBean("testBefinition");
		
		System.out.println(bean.getName());
		System.out.println(bean.getTestclass().isAutoWrized());
	}

}
