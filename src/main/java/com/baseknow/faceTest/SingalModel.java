package com.baseknow.faceTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.LinkedHashMap;

public class SingalModel {

    public static void main(String[] args) {

        getCon();


    }


    public static Connection getCon() {//得到数据库连接的方法
        try {
            Context initial = new InitialContext();//得到上下文引用
            DataSource ds = (DataSource) initial.lookup("java:comp/env/jdbc/connectdb");
            Connection con = ds.getConnection();//得到数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;//返回数据库连接

    }
}