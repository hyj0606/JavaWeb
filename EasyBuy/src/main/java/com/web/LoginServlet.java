package com.web;

import com.pojo.User;
import com.service.LoginService;
import com.service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //编码格式
        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");

        //1.解析表单的数据
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        //2.检查账号和密码的正确性
        LoginService loginService = new LoginServiceImpl();
        User user = loginService.login(account,password);


        //3.判断user是否为空值
        if (user != null){
            //创建会话对象用来存储身份
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            if (user.getType() == 0){

                /*PrintWriter writer = response.getWriter();
                writer.write("0");
                writer.flush();
                writer.close();*/

                response.sendRedirect(request.getContextPath()+"/pCServlet");

            }else if (user.getType() == 1){

                /*PrintWriter writer = response.getWriter();
                writer.write("1");
                writer.flush();
                writer.close();*/

                request.getRequestDispatcher("/Member.jsp").forward(request,response);
            }
        }else{
            /*PrintWriter writer = response.getWriter();
            writer.write("-1");
            writer.flush();
            writer.close();*/
            request.setAttribute("errorMsg","密码或账号错误");
            request.getRequestDispatcher("/Login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
