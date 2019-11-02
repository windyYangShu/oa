package cn.uestc.oa.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编码过滤器类，处理编码格式问题
 */

public class EncodingFilter implements Filter {
    // 设置默认的编码格式
    private String encoding = "utf-8";

    // 完成Filter的初始化参数
    public void init(FilterConfig filterConfig) throws ServletException {
        // 根据初始化参数的名字获取编码格式
        if(filterConfig.getInitParameter("encoding")!=null){
            encoding = filterConfig.getInitParameter("encoding");
        }
    }

    // 实现过滤功能，对每个请求及响应增加的额外请求
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求及响应转换成HttpServletRequest、HttpServletResponse形式
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        // 设置编码格式
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        // Filter只是一个链式处理，处理完成后放行
        filterChain.doFilter(request,response);
    }

    // 用于Filter销毁前完成某些资源的回收
    public void destroy() {
    }
}
