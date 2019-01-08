package mybatis;

import com.baseknow.dubbo.IdubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMain {

    @Autowired
    private IdubboService service;


    public void test(){

        System.out.println(service.getClass().getName());
    }


}
