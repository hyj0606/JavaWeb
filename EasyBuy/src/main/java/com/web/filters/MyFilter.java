package com.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //识别当前请求：
        HttpServletRequest req = (HttpServletRequest) request;
        String contextPath = req.getContextPath();//工程路径
        HttpServletResponse resp = (HttpServletResponse) response;

        //明确限制访问地址:
        List list = new ArrayList();
        list.add(contextPath+"/BrandList.jsp");
        list.add(contextPath+"/Index.jsp");
        list.add(contextPath+"/Login.jsp");
        list.add(contextPath+"/page.jsp");
        list.add(contextPath+"/Product.jsp");
        list.add(contextPath+"/Regist.jsp");//注册页面
        list.add(contextPath+"/BuyCar.jsp");
        list.add(contextPath+"/BuyCar_Two.jsp");
        list.add(contextPath+"/loginServlet");
        list.add(contextPath+"/logout");
        list.add(contextPath+"/plusUpdateServlet");
        list.add(contextPath+"/pCServlet");
        list.add(contextPath+"/productDetailsServlet");
        list.add(contextPath+"/productServlet");
        list.add(contextPath+"/registServlet");
        list.add(contextPath+"/searchServlet");
        list.add(contextPath+"/addBuyCarServlet");
        list.add(contextPath+"/buyCarServlet");
        list.add(contextPath+"/cutUpdateServlet");
        list.add(contextPath+"/plusUpdateServlet");
        list.add(contextPath+"/queryBuyCarServlet");
        list.add(contextPath+"/css/");
        list.add(contextPath+"/images/");
        list.add(contextPath+"/js/");
        /*list.add(contextPath+"/BuyCar_Two.jsp");
        list.add(contextPath+"/buyCarTwoServlet");
        list.add(contextPath+"/BuyCar_Three.jsp");
        list.add(contextPath+"/buyCarThreeServlet");
        list.add(contextPath+"/buyCarAddressServlet");*/

        String uri = req.getRequestURI();

        if( list.contains( uri ) ){
            //放行:
            chain.doFilter(req, resp);
        }else{
            //      其他资源全部拦截
            //需求2: 当登录成功后,session会话中已有身份信息,则允许继续通行
            HttpSession session = req.getSession();
            Object user = session.getAttribute("user");
            if( user != null ){
                //放行:
                chain.doFilter(req, resp);
            }else{
                //没有身份, 继续拦截. 给予提示,并跳回登录页.
                request.setAttribute("errorMsg" , "访问失败,请先登录再进行访问!");
                request.getRequestDispatcher("/Login.jsp").forward(request,resp);
            }
        }

    }
}
