package com.vmax.config.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by wangxiaotao on 2018/7/28.
 * 描述：对http请求和响应做响应的编码处理
 */
@WebFilter(urlPatterns = "/*", filterName = "charsetFilter")
@Order(1)
public class CharsetFilter implements Filter {

    private FilterConfig filterConfig ;

    // 初始化参数配置
    private static String encode = null ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        encode = filterConfig.getInitParameter("encode") == null?"utf-8":filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset="+encode); //--解决响应乱码
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
