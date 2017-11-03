package com.taca.config.filter;

import com.taca.common.constants.FilterConstants;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.common.util.CookieUtil;
import com.taca.model.Admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by jetty on 17/9/20.
 */
@WebFilter(urlPatterns = "/mobile/*", filterName = "mobileLoginFilter")
public class MobileLoginFilter implements Filter{

    private static final Logger LOGGER = LoggerFactory.getLogger(MobileLoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("MobileLoginFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
        String requestUrl=httpRequest.getRequestURL().toString();
        if(FilterConstants.isContainsUrl(FilterConstants.getUnFilterList(),requestUrl)){
            filterChain.doFilter(servletRequest, servletResponse);
            return ;
        }
        HttpSession session=httpRequest.getSession();
        String username=(String) session.getAttribute("username");
        if(username!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            httpResponse.sendRedirect("/mobile/login");
        }
    }

    @Override
    public void destroy() {
        LOGGER.info("MobileLoginFilter destroy...");

    }
}
