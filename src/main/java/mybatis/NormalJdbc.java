package mybatis;

import java.sql.*;

/**
 * 传统jdbc connection
 */
public class NormalJdbc {

    public static void main(String[] args) throws Exception{
        fun1();
    }
    public static void fun2() throws Exception{
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/iscys";
        String username="root";
        String password ="123123";
        //获得连接

        Connection conn = DriverManager.getConnection(url, username, password);

        System.out.println(conn);
        //获取statement
        Statement statement = conn.createStatement();
        String sql ="insert into user (name,password,area) values('cys03','123123','america')";
        //delete update insert 用它
        int result = statement.executeUpdate(sql);
        System.out.println(result);
        //   Show ProcessList ---->mysql query obtain connection thread
        conn.close();
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
    }}
