package com.tw.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取url地址
        String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");

        //当url地址为登录的url的时候跳过拦截器
        if (reqUrl.contains("/login")) {

            return true;
        }

        if (request.getSession().getAttribute("user") != null) {

            return true;
        }

        Cookie cookie = new Cookie("reqUrl", reqUrl);
        response.addCookie(cookie);
        response.sendRedirect("/web/users/login");

        return false;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
