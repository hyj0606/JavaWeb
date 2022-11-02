package com.web;

import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkGoodsNo")
public class CheckGoodsNoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String goodsNo = request.getParameter("goods_no");
        goodsNo = goodsNo == null ? "" : goodsNo;

        try{
            GoodsService goodsService = new GoodsServiceImpl();
            int r = goodsService.checkGoodsNo(goodsNo);

            PrintWriter writer = response.getWriter();
            writer.write( String.valueOf(r) );
            writer.flush();
            writer.close();

        }catch (Exception e1){
            System.out.println();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
