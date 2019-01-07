package mybatis;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 实现没mybatis 的mapper接口扫描，生成动态代理的过程
 * 得意于Spring 扩展机制的实现
 * BeanDefinitionRegistryPostProcessor接口 可以进行Spring bean 容器的修改于添加的操作
 *
 */
public class MapperScanConfig implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware {


    private  String basePackage;//生成其set 方法，在xml中配置扫描的包的路径
    private ApplicationContext applicationContext;


    /**
     * 在被初始化的时候调用此方法,
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        //可以在这里去检查用户是否进行了配置basePackage
        if(getBasePackage()==null){
            throw new IllegalArgumentException("basePackage is require");
        }
    }

    /**
     *
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //spring 提供的包扫描器
        ClassPathScanner scan  =new ClassPathScanner(registry);
        scan.setResourceLoader(this.applicationContext);
        scan.registryFilter();//注册我们定义的filter，进行扫描
        //用来处理传来的多个指定包，我们可以把这个方法看作成是split的作用
        String[] packages = StringUtils.tokenizeToStringArray(getBasePackage(), ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
        scan.scan(packages);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }




    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springTest/mybatis.xml");


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
