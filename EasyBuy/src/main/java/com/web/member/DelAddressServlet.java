package com.web.member;

import com.service.AddressService;
import com.service.OrderService;
import com.service.impl.AddressServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delAddressServlet")
public class DelAddressServlet extends HttpServlet {
    /**
     * 后台地址删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.解析表单传递的数据
        String addressId = request.getParameter("addressId");

        //调用service层
        AddressService addressService = new AddressServiceImpl();
        int result = addressService.del(Integer.valueOf(addressId));

        //ajax
        if (result > 0){
            //删除成功
            response.sendRedirect(request.getContextPath()+"/memberAddressServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
