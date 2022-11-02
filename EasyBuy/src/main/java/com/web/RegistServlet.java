package com.web;

import com.pojo.User;
import com.service.RegistService;
import com.service.impl.RegistServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        response.setContentType("text/html;charset=utf-8");

        //解析表单
        String loginName = request.getParameter("l_user");
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String identityCode = request.getParameter("identity_code");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String type = request.getParameter("type");
        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = sbf.format(d);
        PrintWriter writer = response.getWriter();

        if (loginName != null && loginName != "" && userName != null && userName != "" && password != null && password != ""){

            if (password.equals(pwd)){
                //密码一致
                User user = new User(0, loginName, userName, password, Integer.valueOf(sex), identityCode, email, mobile,createTime, Integer.valueOf(type));
                RegistService registService = new RegistServiceImpl();
                int result = registService.add(user);
                if (result > 0){
                    //注册成功
                    response.sendRedirect(request.getContextPath()+"/Login.jsp");
                }else {
                    //注册失败
                    request.setAttribute("errorMsg","注册失败");
                    /*response.sendRedirect(request.getContextPath()+"/Regist.jsp");*/
                    request.getRequestDispatcher("/Regist.jsp").forward(request,response);
                }

            }else {
                //密码不一致
                request.setAttribute("errorMsg","密码不一致");
                /*response.sendRedirect(request.getContextPath()+"/Regist.jsp");*/
                request.getRequestDispatcher("/Regist.jsp").forward(request,response);
            }

        }else {
            //填写为空
            request.setAttribute("errorMsg"," 请填写完整信息 ");
            /*response.sendRedirect(request.getContextPath()+"/Regist.jsp");*/
            request.getRequestDispatcher("/Regist.jsp").forward(request,response);
        }

        /*if (password.equals(pwd)) {

            User user = new User(0, loginName, userName, password, Integer.valueOf(sex), identityCode, email, mobile,createTime, Integer.valueOf(type));

            if ( loginName != null && loginName != "" && userName != null && userName != "" ){
                RegistService registService = new RegistServiceImpl();
                int result = registService.add(user);
                if (result > 0){

                    response.sendRedirect(request.getContextPath()+"/Login.jsp");
                }else {

                    request.setAttribute("errorMsg","注册失败");
                    request.getRequestDispatcher("/Regist.jsp").forward(request,response);
                }
            }else {

                request.setAttribute("errorMsg","密码不一致");

                request.getRequestDispatcher("/Regist.jsp").forward(request,response);
            }

        }else {

            request.setAttribute("errorMsg"," nihao ");

            request.getRequestDispatcher("/Regist.jsp").forward(request,response);
        }*/
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
