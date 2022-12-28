package com.it.easyexcal.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author WQC
 * @Date 2022/12/24 14:27
 * @Version 1.0
 */
@WebFilter("/")
//@Component  如果加上WebFilter的同时又加上了该注解就是被加入容器两次，也就是意味着被执行两次filter
//正确做法，@WebFilter+启动类上加上@ServletComponentScan
//release-1.0.0开发
public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ssadad");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
