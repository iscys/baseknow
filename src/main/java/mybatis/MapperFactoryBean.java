package mybatis;

import org.springframework.beans.factory.FactoryBean;

public class MapperFactoryBean implements FactoryBean {

    private Class mapperInterface;

    @Override
    public Object getObject() throws Exception {

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
