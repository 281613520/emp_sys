package com.xw.exercise.service;

import com.xw.exercise.entity.Admin;

/**
 * Created by AnKh on 2017/4/3.
 */
public interface AdminService {
    Admin findByNameAndPwd(Admin admin);
}
