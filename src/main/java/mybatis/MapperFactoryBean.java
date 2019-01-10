package mybatis;

import org.springframework.beans.factory.FactoryBean;

/**
 * 实现FactoryBean 接口，实现灵活的bean 装载
 */
public class MapperFactoryBean implements FactoryBean {

    private Class mapperInterface;

    @Override
    public Object getObject() throws Exception {
        //代理生成实现类
        return MybatisProxy.getProxy(mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return this.mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public Class getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }
}
