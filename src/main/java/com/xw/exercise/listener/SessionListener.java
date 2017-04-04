package com.xw.exercise.listener;

import com.xw.exercise.entity.Admin;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.List;

/**
 * Created by AnKh on 2017/4/4.
 */
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession httpSession = httpSessionEvent.getSession();
        ServletContext servletContext = httpSession.getServletContext();

        Object object = httpSession.getAttribute("loginInfo");

        List<Admin> list = (List<Admin>) servletContext.getAttribute("onlineList");
        if (object != null){
            list.remove(object);
        }

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
