package com.xw.exercise.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;

/**
 * Created by AnKh on 2017/4/4.
 */
public class LoginFilter implements javax.servlet.Filter {
    private String uri;
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        String requestPath = uri.substring(uri.indexOf("/") + 1,uri.length());

        if ("admin".equals(requestPath) || "login.jsp".equals(requestPath)){
            filterChain.doFilter(request,response);
        }else {
            HttpSession session = request.getSession();
            if (session != null) {
                Object obj = session.getAttribute("loginInfo");
                if (obj != null) {
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    uri = "/login.jsp";
                }
            } else {
                uri = "/login.jsp";
            }
            request.getRequestDispatcher(uri).forward(request,response);
        }
    }

    public void destroy() {

    }
}
