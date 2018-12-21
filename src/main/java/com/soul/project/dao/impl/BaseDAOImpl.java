package com.soul.project.dao.impl;

import com.soul.project.dao.BaseDAO;
import com.soul.project.utils.DBUtils;
import com.soul.project.utils.Tools;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author soulChun
 * @create 2018-12-17-17:26
 */
public class BaseDAOImpl implements BaseDAO {

    @Override
    public <T> Serializable save(T t) {
        //insert into rz_user(name,age,birth_day) values (?,?,?)
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("insert into ");
        String table = Tools.getTable(t.getClass());
        sBuilder.append(table + " (");

        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.getName().equals("id")) {
                String column = Tools.getColumn(field);
                sBuilder.append(column).append(",");
            }
        }

        sBuilder.deleteCharAt(sBuilder.length() - 1).append(") values (");
        for (Field field : fields) {
            if (!field.getName().equals("id")) {
                sBuilder.append("?,");
            }
        }
        sBuilder.deleteCharAt(sBuilder.length() - 1).append(")");
        System.out.println(sBuilder.toString());

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int index = 1;

        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sBuilder.toString(),new String[]{"id"});
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    //TODO ..拿到T里面对应属性的值，  field => getter
                    String methodName = Tools.getMethod(field, "get");
                    Method method = clazz.getDeclaredMethod(methodName);
                    Object object = method.invoke(t);

                    pstmt.setObject(index++, object);
                }
            }

            int rowCount = pstmt.executeUpdate();
            System.out.println("rowCount = " + rowCount);

            if(rowCount > 0){
               rs = pstmt.getGeneratedKeys();
               rs.next();

               return (Serializable)rs.getObject(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(conn, pstmt, rs);
        }

        return null;
    }

    @Override
    public <T> List query(String sql, Object[] params) {

        //select id,name,age,birth_day from rz_user
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);

            if(params!=null) {
                for (int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }

            ResultSet rs=pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
