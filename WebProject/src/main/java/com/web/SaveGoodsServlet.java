package com.web;

import com.pojo.Goods;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save")
public class SaveGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        //请求参数乱码
//        request.setCharacterEncoding("utf-8");

        //1.解析表单传递的数据
        String id1 = request.getParameter("id");
        String goodsNo = request.getParameter("goods_no");
        String brand1 = request.getParameter("brand");
        String type1 = request.getParameter("type");
        String price1 = request.getParameter("price");
        String info1 = request.getParameter("detail_info");
        String time1 = request.getParameter("time");


        //响应代码
        response.setContentType("text/html; charset=utf-8");
        PrintWriter w = response.getWriter();

        try {

            //封装参数到实体对象中
            Goods g1 = new Goods(Long.valueOf(id1),goodsNo,brand1,type1,Double.valueOf(price1),info1,time1);


            //调用service层实现修改保存
            GoodsService goodsService = new GoodsServiceImpl();
            int r = goodsService.saveGoods(g1);
            w.write(String.valueOf(r));

        } catch (Exception e) {
            System.out.println("报错");
            w.write("-1");
        }
        w.flush();
        w.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
