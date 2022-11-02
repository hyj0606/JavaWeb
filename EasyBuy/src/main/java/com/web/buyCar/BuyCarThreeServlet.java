package com.web.buyCar;

import com.pojo.Order;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/buyCarThreeServlet")
public class BuyCarThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Object orderId=request.getSession().getAttribute("orderId");
        int id=Integer.valueOf((int) orderId);

        Object subtotal=request.getSession().getAttribute("subtotal");
        float cost = Float.valueOf((float) subtotal);

        Date d = new Date();
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = sbf.format(d);

        OrderService orderService = new OrderServiceImpl();
        int result = orderService.saveOrder(id,cost,createTime);

        Order order = orderService.queryOrderId(id);

        request.setAttribute("order",order);

        int num = orderService.delBuyCar( id );

        request.getRequestDispatcher("/BuyCar_Three.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
