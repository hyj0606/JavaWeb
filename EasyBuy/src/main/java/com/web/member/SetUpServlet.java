package com.web.member;

import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/setUpServlet")
public class SetUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String addressId = request.getParameter("addressId");

        //调用service层
        AddressService addressService = new AddressServiceImpl();
        int result = addressService.setUp(Integer.valueOf(addressId));

        if (result > 0){
            //设置成功
            response.sendRedirect(request.getContextPath()+"/memberAddressServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
