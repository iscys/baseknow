package mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MybatisProxy implements InvocationHandler {

    public static <T> T getProxy(Class<T> interfaceClass){

        ClassLoader classLoader = interfaceClass.getClassLoader();
        Class<?>[] interfaces =new Class[]{interfaceClass};
        MybatisProxy proxy = new MybatisProxy();
        return (T)Proxy.newProxyInstance(classLoader,interfaces,proxy);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName =method.getName();
        System.out.println(args);
        fun1();
        return methodName;
    }


    /**
     * preparestatement
     * @throws Exception
     */
    public static void fun1() throws Exception{
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/iscys";
        String username="root";
        String password ="123123";
        //获得连接

        Connection conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);//开启事务
        System.out.println(conn);
        //获取statement
        String sql ="select *from user where name= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,"cys");

        pstm.executeQuery();
        ResultSet resultSet = pstm.getResultSet();
        while(resultSet.next()){
            System.out.println(resultSet.getString("area"));
        }

        conn.commit();
        //   Show ProcessList ---->mysql query obtain connection thread
        conn.close();
    }

}

