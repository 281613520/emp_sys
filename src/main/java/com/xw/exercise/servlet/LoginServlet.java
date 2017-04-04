package com.xw.exercise.servlet;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import com.xw.exercise.entity.Admin;
import com.xw.exercise.service.AdminService;
import com.xw.exercise.service.impl.AdminServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnKh on 2017/4/3.
 */
public class LoginServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    private String uri;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getMethod();
        if ("login".equals(method)){
            login(req,resp);
        }else if("out".equals(method)){
            out(req,resp);
        }
    }

    private void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setPassword(password);

        try {
            Admin logininfo = adminService.findByNameAndPwd(admin);
            if(logininfo == null){
                uri = "/login.jsp";
            }else{
                request.getSession().setAttribute("loginInfo",logininfo);
                ServletContext servletContext = getServletContext();
                List<Admin> onlineList = (List<Admin>) servletContext.getAttribute("onlineList");
                if (onlineList != null){
                    onlineList.add(logininfo);
                }
                uri = "/index";
            }
        }catch(Exception e){
            e.printStackTrace();
            uri = "/error/error.jsp";
        }
        request.getRequestDispatcher(uri).forward(request,response);
    }

    private void out(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null){
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
