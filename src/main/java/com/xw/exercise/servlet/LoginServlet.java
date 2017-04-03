package com.xw.exercise.servlet;

import com.xw.exercise.entity.Admin;
import com.xw.exercise.service.AdminService;
import com.xw.exercise.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by AnKh on 2017/4/3.
 */
public class LoginServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    private String uri;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);

        Admin logininfo = adminService.findByNameAndPwd(admin);
        try {
            if (logininfo == null) {
                uri = "/login.jsp";
            } else {
                req.getSession().setAttribute("logininfo", logininfo);
                uri = "/index";
            }
        }catch (Exception e){
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        req.getRequestDispatcher(uri).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
