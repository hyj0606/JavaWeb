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

@WebServlet("/queryBuyCarServlet")
public class QueryBuyCarServlet extends HttpServlet {
    /**
     * 购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<BuyCar> buyCarList = productService.queryBuyCar();

        String jsonStr = JSON.toJSONString(buyCarList);

        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonStr);
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
