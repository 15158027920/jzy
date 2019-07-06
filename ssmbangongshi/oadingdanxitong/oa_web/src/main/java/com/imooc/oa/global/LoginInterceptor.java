package com.imooc.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jzy
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        //url是否有login关键字,toLowerCase()转换为小写，>=0即包含
        //忽略大小写
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }

        //判断是否登录，通过session来判断,获取GlobalController传来的session
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("employee")!=null){
            //employee不为null，已经登录了，放行
            return true;
        }
        httpServletResponse.sendRedirect("/to_login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) throws Exception {

    }
}
