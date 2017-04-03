package com.xw.exercise.dao;

import com.xw.exercise.entity.Admin;

/**
 * Created by AnKh on 2017/4/3.
 */
public interface AdminDao {
    Admin findByNameAndPwd(Admin admin);
}
