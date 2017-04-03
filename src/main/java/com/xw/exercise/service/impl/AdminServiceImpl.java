package com.xw.exercise.service.impl;

import com.xw.exercise.dao.AdminDao;
import com.xw.exercise.dao.impl.AdminDaoimpl;
import com.xw.exercise.entity.Admin;
import com.xw.exercise.service.AdminService;

/**
 * Created by AnKh on 2017/4/3.
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoimpl();
    public Admin findByNameAndPwd(Admin admin) {
        return adminDao.findByNameAndPwd(admin);
    }
}
