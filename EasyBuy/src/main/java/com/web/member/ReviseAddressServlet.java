package com.web.member;

import com.pojo.Address;
import com.pojo.User;
import com.service.AddressService;
import com.service.impl.AddressServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/reviseAddressServlet")
public class ReviseAddressServlet extends HttpServlet {
    /**
     * 地址修改
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
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setMobile(mobile);

        String id = request.getParameter("id");
        String address = request.getParameter("address");
        String remark = request.getParameter("remark");

        //封装数据至对象中
        Address address1 = new Address();
        address1.setId(Integer.valueOf(id));
        address1.setAddress(address);
        address1.setRemark(remark);
        address1.setUser(user);


        //存储: 调用至service层
        AddressService addressService = new AddressServiceImpl();
        int result = addressService.edit(address1);

        if (result > 0){
            //修改成功:
            response.sendRedirect(request.getContextPath()+"/memberAddressServlet");

        }else {
            //存储失败: 回到之前页面重填
            response.sendRedirect(request.getContextPath()+"/reviseAddressServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
