package com.web.buyCar;

import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@WebServlet("/buyCarAddressServlet")
public class BuyCarAddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id"); //address的主键
        //根据主键id获得
        String address = request.getParameter("address");//地址

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int ranNum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        String run = ranNum+str;//订单编号

        OrderService orderService = new OrderServiceImpl();
        int orderId = orderService.addAddress(Integer.valueOf(id),run);

        HttpSession session = request.getSession();
        session.setAttribute("orderId",orderId);//订单编号id


        PrintWriter writer = response.getWriter();
        writer.write("1");
        writer.flush();
        writer.close();



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
