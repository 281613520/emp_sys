package com.xw.exercise.servlet;

import com.xw.exercise.entity.Employee;
import com.xw.exercise.service.EmployeeService;
import com.xw.exercise.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by AnKh on 2017/4/3.
 */
public class IndexServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private String uri;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            List<Employee> list = employeeService.getAll();
            req.setAttribute("listEmp",list);
            uri = "/list.jsp";
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
