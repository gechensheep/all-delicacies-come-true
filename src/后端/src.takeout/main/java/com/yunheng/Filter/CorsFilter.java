package com.yunheng.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 设置允许跨域请求的域名
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        // 设置允许跨域请求的方法
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        // 设置允许跨域请求的头部信息
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");

        System.out.println("corsfilter已执行");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作
    }

    @Override
    public void destroy() {
        // 销毁操作
    }
}
