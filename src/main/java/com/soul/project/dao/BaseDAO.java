package com.soul.project.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author soulChun
 * @create 2018-12-17-17:25
 */
public interface BaseDAO {

   <T> Serializable save(T t);
   <T> List query(String sql,Object[] params);

}
