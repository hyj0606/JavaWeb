package com.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @ClassName MyFilter1
 * @Description 定义组件： 实现接口，继承父类
 * @Author hyj98
 * @Date 2022-10-08 11:51
 * @Version 1.0
 */
@WebFilter("/*")
public class CharsetFilter implements Filter {

    //过滤器初始化:
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //当客户端请求时,过滤方法:
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //设置参数的编码
        servletRequest.setCharacterEncoding("utf-8");

        servletResponse.setContentType("text/html; charset=utf-8");

        //模拟放行:当前的过滤器不进行任何拦截或过滤,放到下一个过滤器中,如果没有其他过滤器,那就直接到达目标资源中.
        filterChain.doFilter(servletRequest, servletResponse);

    }

    //当过滤器销毁时,销毁前任务
    @Override
    public void destroy() {

    }
}
