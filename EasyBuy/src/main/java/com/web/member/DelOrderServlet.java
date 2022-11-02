package com.web.member;

import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delOrderServlet")
public class DelOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.解析表单传递的数据
        String orderId = request.getParameter("orderId");
        String isDelete = request.getParameter("isDelete");

        //调用service层
        OrderService orderService = new OrderServiceImpl();
        int result = orderService.del(Integer.valueOf(orderId), Integer.valueOf(isDelete));

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        //ajax
        if (result > 0){
            response.sendRedirect(request.getContextPath()+"/memberOrderServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
