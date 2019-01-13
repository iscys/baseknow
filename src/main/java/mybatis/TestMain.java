package mybatis;

import com.baseknow.dubbo.IdubboService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMain {

    @Autowired
    private IdubboService service;


    public void test(){
       // MapperFactoryBean
        //SqlSessionFactoryBean
        System.out.println(service.sayBye("1","1"));
        System.out.println(service.getClass().getName());
    }


}
