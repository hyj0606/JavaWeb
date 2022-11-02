package com.web.member;

import com.pojo.Detail;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/toSeeOrderServlet")
public class ToSeeOrderServlet extends HttpServlet {
    /**
     * 后台订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");

        OrderService orderService = new OrderServiceImpl();
        List<Detail> detailList = orderService.queryById(Integer.valueOf(orderId));

        HttpSession session = request.getSession();
        session.setAttribute("detailList",detailList);

        request.getRequestDispatcher("/Order_Detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
