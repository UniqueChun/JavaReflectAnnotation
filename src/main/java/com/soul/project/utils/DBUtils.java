package com.soul.project.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author soulChun
 * @create 2018-12-17-16:55
 */
public class DBUtils {

    //获取连接
    public static Connection getConnection() {

        Connection conn = null; //连接
        Statement stmt = null;//状态
        ResultSet rs = null;//结果集
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soul", "root", "root");
            //
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn,Statement stmt,ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

