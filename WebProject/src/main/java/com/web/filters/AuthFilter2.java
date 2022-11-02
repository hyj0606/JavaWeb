package com.web.filters;

import com.pojo.User;

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
public class AuthFilter2 implements Filter {

    //过滤器初始化:
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //当客户端请求时,过滤方法:
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //普通员工:
        List list1 = new ArrayList();
        list1.add("/WebProject/query");
        list1.add("/WebProject/goods_list.jsp");
        Map<String,List> map = new HashMap();
        map.put("普通员工",list1);

        //管理员
        List list2 = new ArrayList();
        list2.add("/WebProject/query");
        list2.add("/WebProject/goods_list.jsp");
        list2.add("/WebProject/add");
        list2.add("/WebProject/add_goods.jsp");
        list2.add("/WebProject/del");
        list2.add("/WebProject/toEdit");
        list2.add("/WebProject/edit_goods.jsp");
        list2.add("/WebProject/checkGoodsNo");
        list2.add("/WebProject/save");
        map.put("管理员",list2);

        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        //1.解析登录者的身份角色: 如果有,继续.  没有,提示无权访问
        HttpSession session = req.getSession();
        User loginUser = (User)session.getAttribute("login_user");
        String roleName = loginUser.getRoleName();
        if ( roleName != null && !roleName.equals("") ){

            //2.根据角色查询对应访问的权限: List.
            List list = map.get(roleName);

            //3.解析当前访问的资源地址(权限) : String uri
            String uri = req.getRequestURI();

            //4.判断uri是否在List中出现.  出现:放行.  不出现:提示无权访问
            if (list.contains(uri)){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                //提示无权访问:
                resp.sendRedirect("/WebProject/no_auth.jsp");
            }

        }else {
            //提示无权访问:
            resp.sendRedirect("/WebProject/no_auth.jsp");
        }

    }

    //当过滤器销毁时,销毁前任务
    @Override
    public void destroy() {

    }
}
