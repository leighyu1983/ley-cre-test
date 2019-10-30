package com.ley.interceptor;

import com.google.common.base.Strings;
import com.ley.exception.InvalidTokenException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (handler instanceof HandlerMethod) {
            String token = request.getHeader("Authorization");
            if(Strings.isNullOrEmpty(token) || "hmmm".equals(token)) {
                throw new InvalidTokenException();
            }
            //HandlerMethod handlerMethod = (HandlerMethod) handler;
            //log.info("拦截 Controller："+ handlerMethod.getBean().getClass().getName());
            //log.info("拦截方法："+handlerMethod.getMethod().getName());
        }

        return true;
    }
}
