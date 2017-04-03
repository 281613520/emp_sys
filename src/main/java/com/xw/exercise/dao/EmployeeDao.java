package com.xw.exercise.dao;

import com.xw.exercise.entity.Employee;

import java.util.List;

/**
 * Created by AnKh on 2017/4/3.
 */
public interface EmployeeDao {
    List<Employee> getAll();
}
