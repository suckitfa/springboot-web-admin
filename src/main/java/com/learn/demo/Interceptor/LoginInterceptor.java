package com.learn.demo.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 拦截器
// 拦截器机制
// 1. 配置好拦截器，拦截请求
// 2. 将配置放入容器中,注册拦截器，重新实现WebMvcConfigurer
// 3. 指定拦截路径
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截请求路径是:{}",requestURI);
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null) {
            // 放行
            return true;
        }
        // 跳转
        response.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle = {}",request.getMethod());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler, Exception ex) throws Exception {
        log.info("afterCompletion = {}",request.getMethod());
    }
}
