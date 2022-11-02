package com.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyFilter1
 * @Description 定义组件： 实现接口，继承父类
 * @Author hyj98
 * @Date 2022-10-08 11:51
 * @Version 1.0
 */
@WebFilter("/*")
public class AuthFilter1 implements Filter {

    //过滤器初始化:
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //当客户端请求时,过滤方法:
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //用于检查指定资源在访问时，当前登录身份是否存在
        List list = new ArrayList();
        //三个完整地址
        list.add("/WebProject/login.jsp");
        list.add("/WebProject/no_auth.jsp");
        list.add("/WebProject/login");
        list.add("/WebProject/logout");

        //这是一个静态资源地址目录位置
        String resourcePath = "/WebProject/static/";

        Map<String,List> map = new HashMap();
        map.put("anon",list);

        //识别当前请求
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String uri = req.getRequestURI();

        List anonList = map.get("anon");
        if (anonList.contains(uri) || uri.startsWith(resourcePath)){
            //请求地址是否可以匿名访问:如果是直接放行
            //filterChain.doFilter(req,servletResponse);
            String location = uri.replace("/WebProject", "");
            req.getRequestDispatcher(location).forward(req,resp);

        }else {
            //如果不是: 检查登陆身份,已登录,则直接放行
            HttpSession session = req.getSession();
            Object loginUser = session.getAttribute("login_user");

            if (loginUser != null){
                //放行:
                filterChain.doFilter(req,servletResponse);

            }else {
                //如果未登录: 不放行,并强制跳往登录页面
                resp.sendRedirect("/WebProject/login.jsp");

            }
        }
    }

    //当过滤器销毁时,销毁前任务
    @Override
    public void destroy() {

    }
}
