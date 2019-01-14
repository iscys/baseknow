package mybatis;

import com.baseknow.utils.ResourceUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;

/**
 * sqlSession 工厂
 * 实例化SqlSessionFactory 对象
 */
public class SqlSessionFactory implements FactoryBean , InitializingBean {

   // private Resource[] mapperLocations;//spring 机制会自动将文件进行装配加载成Resource对象
    private String mapperLocations;
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //初始化后进行sqlSessionFactory 的创建，解析XML 文件的sql
        buildSqlSessionFactory();

    }

    public void buildSqlSessionFactory() throws Exception {
        MapperConfiguration config =new MapperConfiguration();
        LinkedList<File> files = ResourceUtils.scanPackage(mapperLocations,ResourceUtils.MATCH_XML);
        for(File parseXml :files){
            XmlBuilder xmlBuilder =new XmlBuilder(new FileInputStream(parseXml),config);
            xmlBuilder.parse();

        }


    }

    public static void main(String[] args) {


    }
}
