package com.web.buyCar;

import com.alibaba.fastjson.JSON;
import com.pojo.Address;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/buyCarTwoServlet")
public class BuyCarTwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        AddressService addressService = new AddressServiceImpl();
        List<Address> addressList = addressService.queryId(Integer.valueOf(id));

        request.setAttribute("addressList",addressList);

        request.getRequestDispatcher("/BuyCar_Two.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
