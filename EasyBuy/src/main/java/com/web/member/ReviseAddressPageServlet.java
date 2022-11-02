package com.web.member;

import com.pojo.Address;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/reviseAddressPageServlet")
public class ReviseAddressPageServlet extends HttpServlet {
    /**
     *
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
        Address address  = addressService.queryById(Integer.valueOf(addressId));

        request.setAttribute("address",address);

        if (address != null) {
            request.getRequestDispatcher("/Revise_Address.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
