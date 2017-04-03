package com.xw.exercise.dao.impl;

import com.xw.exercise.dao.AdminDao;
import com.xw.exercise.entity.Admin;
import com.xw.exercise.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by AnKh on 2017/4/3.
 */
public class AdminDaoimpl implements AdminDao {
    public Admin findByNameAndPwd(Admin admin) {
        try {
            String sql = "SELECT * FORM admin where useName=? and password=?";
            return JDBCutils.getQueryRunner().query(sql,new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
