package mybatis;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * 继承Spring 提供的包扫描器，主要是为了使用其内部的doscan 方法；
 */
public class ClassPathScanner extends ClassPathBeanDefinitionScanner {


    public ClassPathScanner(BeanDefinitionRegistry registry) {
        super(registry,false);
    }


    @Override
    public  Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> holder= super.doScan(basePackages);

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
}
