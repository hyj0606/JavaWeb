package com.web.buyCar;

import com.pojo.BuyCar;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/buyCarServlet")
public class BuyCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<BuyCar> buyCarList = productService.queryAllBuyCar();

        float subtotal = 0;

        for (int i = 0; i < buyCarList.size(); i++) {

            subtotal = subtotal + (buyCarList.get(i).getProductNum()*buyCarList.get(i).getProduct().getPrice());

        }

        HttpSession session = request.getSession();


        session.setAttribute("subtotal",subtotal);

        session.setAttribute("buyCarList",buyCarList);

        request.getRequestDispatcher("/BuyCar.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
