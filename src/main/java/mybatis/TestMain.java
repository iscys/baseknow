package mybatis;

import com.baseknow.dubbo.IdubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMain {

    @Autowired
    private IdubboService service;


    public void test(){
       //MapperFactoryBean
        //SqlSessionFactoryBean
        System.out.println(service.sayBye("1","1"));
        System.out.println(service.getClass().getName());
    }

    public static void main(String[] args) {

        Integer a=123;
        Integer b= new Integer(123);
        int c=178;
        System.out.println(c==b);
    }

}
