package com.soul.project.utils.dao.impl;

import com.soul.project.dao.BaseDAO;
import com.soul.project.dao.impl.BaseDAOImpl;
import com.soul.project.domain.User;
import org.junit.Test;

import java.io.Serializable;
import java.util.Date;

/**
 * @author soulChun
 * @create 2018-12-17-17:35
 */
public class BaseDAPImplTest {




    @Test
    public void testQuery() {
        BaseDAO dao = new BaseDAOImpl();
        dao.query("select * from rz_user");

    }
    @Test
    public void testSave() {
        BaseDAO dao = new BaseDAOImpl();

//        for(int i =0;i<10;i++) {
//            User user = new User("soul"+i, 20+i, new Date());
//            dao.save(user);
//        }

        User user = new User("soul100", 31, new Date());
        Serializable id = dao.save(user);
        System.out.println(id);

    }
}
