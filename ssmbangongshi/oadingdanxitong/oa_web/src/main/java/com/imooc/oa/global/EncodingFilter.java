package com.imooc.oa.global;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jzy
 * 编辑过滤器解决乱码问题
 */
public class EncodingFilter implements Filter{

    private String encoding="utf-8";
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取初始化参数
        if(filterConfig.getInitParameter("encoding")!=null){
            encoding = filterConfig.getInitParameter("encoding");
        }
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request,response);
    }


    public void destroy() {

    }
}
