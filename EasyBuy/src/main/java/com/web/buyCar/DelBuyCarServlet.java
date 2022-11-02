package com.web.buyCar;

import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delBuyCarServlet")
public class DelBuyCarServlet extends HttpServlet {
    /**
     * 购物车内容删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ProductService productService = new ProductServiceImpl();
        int result = productService.delBuyCar( Integer.valueOf(id) );

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
