package com.xw.exercise.listener;

import com.xw.exercise.entity.Admin;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AnKh on 2017/4/4.
 */
public class OnlineAdminListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        List<Admin> onlineList = new ArrayList<Admin>();
        servletContextEvent.getServletContext().setAttribute("onlineList",onlineList);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Object obj = servletContext.getAttribute("onlineList");
        if (obj != null){
            servletContext.removeAttribute("onlineList");
        }
    }
}
