package com.web.member;

import com.pojo.Page;
import com.service.AddressService;
import com.service.OrderService;
import com.service.impl.AddressServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/memberAddressServlet")
public class MemberAddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解析获取表单数据
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
        AddressService addressService = new AddressServiceImpl();
        Page page  = addressService.queryAll(pNo,pSize );

        //封装商品的分页查询地址,当前地址查询条件到page对象中: 随着page传递至页面中
        page.setUrl(request.getContextPath()+"/memberAddressServlet");  //给商品的分页查询地址

        //2.将获得结果传递给视图
        request.setAttribute("page",page);

        //转发到Member_Order.jsp界面
        request.getRequestDispatcher("/Member_Address.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
