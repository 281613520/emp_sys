package com.xw.exercise.dao.impl;

import com.xw.exercise.dao.EmployeeDao;
import com.xw.exercise.entity.Employee;
import com.xw.exercise.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnKh on 2017/4/3.
 */
public class EmployeeDaoimpl implements EmployeeDao {
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        try {
            return JDBCutils.getQueryRunner().query(sql,new BeanListHandler<Employee>(Employee.class));
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
