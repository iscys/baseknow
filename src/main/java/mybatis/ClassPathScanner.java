package mybatis;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * 继承Spring 提供的包扫描器，主要是为了使用其内部的doscan 过滤器方法；
 */
public class ClassPathScanner extends ClassPathBeanDefinitionScanner {


    public ClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry,false);
    }


    @Override
    public  Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> holder= super.doScan(basePackages);
        //获取到Spring容器BeanDefinition 的信息，进行修改的操作
        for(BeanDefinitionHolder holde :holder){
            GenericBeanDefinition  gen= (GenericBeanDefinition)holde.getBeanDefinition();
            MutablePropertyValues propertyValues = gen.getPropertyValues();
            //properties 为属性进行赋值的操作
            propertyValues.add("mapperInterface",gen.getBeanClassName());
            //根据接口设置代理类，这个类需要实现FactoryBean 的接口，这样可以动态生成代理对象
            gen.setBeanClass(MapperFactoryBean.class);
            //实例化会进行自动属性的注入
            gen.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);


        }


        return holder;
    }

    public void registryFilter() {

        addIncludeFilter(new TypeFilter(){

            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
    }


    /**
     * 这个方法可以扫描到接口的信息，只要是接口就可以被扫描到；
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return (beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent());
    }



}
