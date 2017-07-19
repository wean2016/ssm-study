package main.cn.wean2016.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hasee on 2017/7/18.
 */
public class FirstInterceptor implements HandlerInterceptor {
    // 调用目标方法之前
    // 可以做权限 日志 事务
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("FirstInterceptor   preHandle");

        return true;
    }
    // 调用目标方法之后，渲染视图之前
    // 可以对请求域中的属性或视图做出修改
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor    postHandle");
    }
    // 渲染视图之后被调用
    // 释放资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("FirstInterceptor     afterCompletion");
    }
}
