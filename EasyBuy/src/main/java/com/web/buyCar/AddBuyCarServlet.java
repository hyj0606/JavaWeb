package com.web.buyCar;

import com.alibaba.fastjson.JSON;
import com.pojo.Page;
import com.pojo.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addBuyCarServlet")
public class AddBuyCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ProductService productService = new ProductServiceImpl();

        int n = productService.queryBuyCarById(Integer.valueOf(id));
        int result = 0;
        if (n == 0){
            result = productService.addBuyCar(Integer.valueOf(id));
        }else {
            result = productService.addBuyCarById(n);
        }

        PrintWriter writer = response.getWriter();
        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
