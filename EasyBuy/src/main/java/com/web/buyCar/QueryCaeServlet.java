package com.web.buyCar;

import com.alibaba.fastjson.JSON;
import com.pojo.BuyCar;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/queryCaeServlet")
public class QueryCaeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<BuyCar> buyCarList = productService.queryAllBuyCar();

        float subtotal = 0;

        /*for (int i = 0; i < buyCarList.size(); i++) {

            subtotal = subtotal + (buyCarList.get(i).getProductNum()*buyCarList.get(i).getProduct().getPrice());

        }*/

        /*HttpSession session = request.getSession();


        session.setAttribute("subtotal",subtotal);*/

        response.setContentType("text/json;charset=utf-8");

        PrintWriter writer = response.getWriter();

        String jsonStr = JSON.toJSONString(buyCarList);

        writer.write(jsonStr);
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
