package com.baseknow.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 扩展组件先后执行顺序
 * @author cys
 *
 */
public class SpringCustome implements InitializingBean,
BeanDefinitionRegistryPostProcessor,ApplicationContextAware {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:springTest/my.xml");
		
	}
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			System.out.println("ApplicationContextAware执行");
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.err.println("BeanDefinitionRegistry执行");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		
		System.out.println("InitializingBean执行");
		
	}

	
}
