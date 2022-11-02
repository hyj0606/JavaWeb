package com.web;

import com.pojo.BuyCar;
import com.pojo.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/productDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
    /**
     * 详情列表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ProductService productService = new ProductServiceImpl();
        Product product = productService.queryProduct(Integer.valueOf(id));

        request.setAttribute("product",product);

        request.getRequestDispatcher("/Product.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
