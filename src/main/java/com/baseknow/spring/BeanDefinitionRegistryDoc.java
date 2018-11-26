package com.baseknow.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * spring 通过暴露BeanDefinitionRegistryPostProcessor 接口，
 * 可以使我们在spring中加载一些我们自定义的bean，被spring 所初始化；例如
 * mybatis 接口代理对象就是通过这种方式加载进来的
 * 接下来模拟接口代理的生成方法
 * 1.知识补充，都知道，在我们的bean 对象被spring管理后，spring在获取bean 对象时候调用的是getBean()方法
 * 默认下getBean 返回的是该类的无参数构造，当然还有一种就是对于实现了FactoryBean 接口的类，在spring调用
 * getBean()方法时候，调用的是FactoryBean 下的 getObject方法所返回的对象，所以利用特性，可以进行生成接口的
 * 代理；dubbo也是如此
 * 
 * @author iscys
 *
 */
public class BeanDefinitionRegistryDoc implements BeanDefinitionRegistryPostProcessor {

	
	public static void main(String[] args) {
	ApplicationContext app = new ClassPathXmlApplicationContext("classpath:springTest/my.xml");
		
	Object bean = app.getBean("testInterface");
	System.out.println(bean instanceof TestInterface);
	}
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 通过这个方法将我们自定义的bean 进行加载进来
	 */
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition beanDefinition =new GenericBeanDefinition();
		//设置bean class对象交给BeanFactory 进行创建
		beanDefinition.setBeanClass(BeanFactory.class);
		//也可以给置顶bean 进行属性的添加
		beanDefinition.getPropertyValues().addPropertyValue("needProxyInterface", "com.baseknow.spring.TestInterface");
		registry.registerBeanDefinition("testInterface", beanDefinition);
	}



}
/**
 * 实现FactoryBean bean工厂
 * 不会直接的作为bean 的实例暴露在外边，而是通过getObject 方法
 * 进行对象的引用，也就是说这个对象的实例是通过getObject 方法返回的
 * @author cys
 *
 */
class BeanFactory implements FactoryBean{
	
	
	private Class needProxyInterface;

	public Class getNeedProxyInterface() {
		return needProxyInterface;
	}

	public void setNeedProxyInterface(Class needProxyInterface) {
		this.needProxyInterface = needProxyInterface;
	}

	@Override
	public Object getObject() throws Exception {
		System.out.println("---------getObject");
		return "1";
	}

	@Override
	public Class getObjectType() {
		return this.needProxyInterface;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	
}

interface TestInterface{
	
	void testMethod();
}


