package cn.uestc.oa.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 使用springMVC中的请求拦截,主要作用是拦截用户请求并进行相应的处理
 * 常用来：进行用户权限验证；判断用户是否已经登录
 */

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 该方法在当前请求处理之前被调用，当返回为false时后续的Interceptor和Controler都不会被调用，返回true时继续执行下一个Interceptor
     * 所有的Interceptor采用的链式调用
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        // 根据请求的路径中是否包含有login字符串来确定是否是注册
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }

        HttpSession session = httpServletRequest.getSession();
        // 判断当前页面中是否包含员工信息
        if(session.getAttribute("employee")!=null){
            return true;
        }
        // 重定向至登录界面
        httpServletResponse.sendRedirect("/to_login");
        return false;
    }

    /**
     * 该方法在当前请求处理之后被调用
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    /**
     * 该方法在所有请求处理之后被调用
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
