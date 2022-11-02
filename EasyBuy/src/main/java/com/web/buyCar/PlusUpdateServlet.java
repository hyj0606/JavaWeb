package com.web.buyCar;

import com.pojo.BuyCar;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/plusUpdateServlet")
public class PlusUpdateServlet extends HttpServlet {
    /**
     * 购买数量减一
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ProductService productService = new ProductServiceImpl();
        int result = productService.plusUpdate( Integer.valueOf(id) );

        PrintWriter writer = response.getWriter();

        if (result > 1){
            writer.write("1");
        }else {
            writer.write("0");
        }

        writer.flush();
        writer.close();

        /*request.getRequestDispatcher("/buyCarServlet").forward(request,response);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
