package com.web.member;

import com.alibaba.fastjson.JSON;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.RegistServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkUserNameServlet")
public class CheckUserNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String userName = request.getParameter("userName");
        userName = userName == null ? "" : userName;

        User user = userService.checkUserName(userName);

        request.setAttribute("user",user);

        if (user != null){
            PrintWriter writer = response.getWriter();
            writer.write( "1" );
            writer.flush();
            writer.close();
            request.getRequestDispatcher("/Member_address.jsp").forward(request,response);
        }*/


        String loginName = request.getParameter("l_user");
        loginName = loginName == null ? "" : loginName;

        UserService userService = new UserServiceImpl();
        int result = userService.checkLoginName(loginName);
        PrintWriter writer = response.getWriter();
        writer.write( String.valueOf(result) );
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
