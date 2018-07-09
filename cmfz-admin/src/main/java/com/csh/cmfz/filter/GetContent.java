package com.csh.cmfz.filter;


import com.csh.cmfz.entity.SysContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 通过过滤器 获得请求中的sessio和request
 * @Author 程少华
 * @Date 2018/7/9 20:10
 **/
public class GetContent implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SysContext.setRequestLocal((HttpServletRequest) servletRequest);
        SysContext.setResponseLocal((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
