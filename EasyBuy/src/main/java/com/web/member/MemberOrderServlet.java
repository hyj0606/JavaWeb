package com.web.member;

import com.pojo.Page;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/memberOrderServlet")
public class MemberOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查询条件:
        String serialNumber = request.getParameter("serialNumber");
        serialNumber = serialNumber == null ? "" : serialNumber;

        //进行分页展示
        //1.明确查询页码
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");

        //检查请求参数
        int pNo = 1;
        if (pageNo != null && !pageNo.equals("")){
            //采用客户请求的页码
            pNo = Integer.valueOf(pageNo);
        }
        int pSize = 5;
        if (pageSize != null && !pageSize.equals("")){
            pSize = Integer.valueOf(pageSize);
        }

        //查询所有订单商品---->service层
        OrderService orderService = new OrderServiceImpl();
        Page page = orderService.queryAll(serialNumber, pNo,pSize );

        //封装商品的分页查询地址,当前地址查询条件到page对象中: 随着page传递至页面中
        page.setUrl(request.getContextPath()+"/memberOrderServlet");  //给商品的分页查询地址
        page.setCondition("&serialNumber="+serialNumber); //给商品的分页查询条件

        //2.将获得结果传递给视图
        request.setAttribute("page",page);
        request.setAttribute("serialNumber",serialNumber);

        //转发到Member_Order.jsp界面
        request.getRequestDispatcher("/Member_Order.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
