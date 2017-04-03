package com.xw.exercise.service.impl;

import com.xw.exercise.dao.EmployeeDao;
import com.xw.exercise.dao.impl.EmployeeDaoimpl;
import com.xw.exercise.entity.Employee;
import com.xw.exercise.service.EmployeeService;

import java.util.List;

/**
 * Created by AnKh on 2017/4/3.
 */
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao = new EmployeeDaoimpl();
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
}
