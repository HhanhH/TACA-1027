package com.taca.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taca.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by jetty on 17/9/20.
 */
@WebFilter(urlPatterns = "/admin/*", filterName = "adminLoginFilter")
public class AdminLoginFilter implements Filter{

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("AdminLoginFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
    	String requestUrl=httpRequest.getRequestURL().toString();
        if(requestUrl.contains("goLogin")||requestUrl.contains("login")){
        	 filterChain.doFilter(servletRequest, servletResponse);
        	 return ;
        }
    	
         HttpSession session=httpRequest.getSession();
         Admin admin =  (Admin) session.getAttribute("admin");
         if(admin!=null){
        	 filterChain.doFilter(servletRequest, servletResponse);
         }
         else{
             httpResponse.sendRedirect("/admin/goLogin");
         }
    	
    }

    @Override
    public void destroy() {
        LOGGER.info("AdminLoginFilter destroy...");

    }
}
