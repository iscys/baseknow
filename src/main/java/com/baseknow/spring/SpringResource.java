package com.baseknow.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * spring 提供了Resource 接口，方便我们操作资源文件，
 * 1.需要进行XML配置资源路径
 * 2.类中定义Resource 变量，有它的 set 方法
 * 比如：如下 xml 配置
 * <bean id ="springResource" class="com.baseknow.spring.SpringResource">
 * 	<property name="configuration" value="classpath:git/java.gitignore"></property>
 * </bean>
 * 
 * 这样文件就会被自动注入到对象中
 * @author iscys
 *
 */
public class SpringResource implements InitializingBean{
	
	private Resource configuration;
	
	private Resource[] configurations;

	public void setConfiguration(Resource configuration) {
		this.configuration = configuration;
	}
	public void setConfigurations(Resource[] configurations) {
		this.configurations = configurations;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(configuration.getFile());
		System.out.println(configurations.getClass());
		
	}
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:springTest/springReource.xml");
		
	}

}
