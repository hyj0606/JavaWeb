package com.web.member;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/memberUserServlet")
public class MemberUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        //1.查询所有商品--->service层
        UserService userService = new UserServiceImpl();
        User user = userService.queryAll(Integer.valueOf(id));

        //2.将获得结果传递给视图
        request.setAttribute("user",user);

        //转发到首页index.jsp
        request.getRequestDispatcher("/Member_User.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
