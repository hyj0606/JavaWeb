package com.web.member;

import com.pojo.Address;
import com.pojo.User;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addAddressServlet")
public class AddAddressServlet extends HttpServlet {

    /**
     * 后台添加地址
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置post传递参数中文乱码
        request.setCharacterEncoding("utf-8");

        //单独解析商品的编号:  才能针对该商品修改

        String id = request.getParameter("id");
        User user = new User();
        user.setId(Integer.valueOf(id));

        String address = request.getParameter("address");
        String tel = request.getParameter("tel");
        String remark = request.getParameter("remark");

        //封装数据至对象中
        Address address1 = new Address();
        address1.setUser(user);
        address1.setAddress(address);
        address1.setTel(tel);
        address1.setRemark(remark);


        //存储: 调用至service层
        AddressService addressService = new AddressServiceImpl();
        int result = addressService.add(address1);

        if (result > 0){
            //添加成功
            response.sendRedirect(request.getContextPath()+"/memberAddressServlet");

        }else {
            //添加失败
            response.sendRedirect(request.getContextPath()+"/reviseAddressServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
