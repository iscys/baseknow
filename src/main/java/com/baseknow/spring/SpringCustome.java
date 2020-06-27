package com.baseknow.spring;

import org.springframework.asm.ClassReader;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * spring 扩展组件先后执行顺序
 * @author cys
 *
 */
public class SpringCustome implements InitializingBean,
BeanDefinitionRegistryPostProcessor,ApplicationContextAware {


	private ApplicationContext context;
	public static void main(String[] args)throws Exception {

		List<String> list =new ArrayList<String>();
		list.add("12131");
		final Type genericSuperclass = list.getClass().getGenericSuperclass();

		System.out.println();

	}
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			System.out.println("ApplicationContextAware执行");
			this.context=applicationContext;
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.err.println("BeanDefinitionRegistry执行");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//可以获取spring注册的bean
		SpringCustome springCustome = BeanFactoryUtils.beanOfType(context, SpringCustome.class);
		System.out.println(springCustome);

	}


}
