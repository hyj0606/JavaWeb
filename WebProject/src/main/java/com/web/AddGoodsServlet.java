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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/add")
public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        //请求参数乱码:已抽取至过滤器中完成
        //request.setCharacterEncoding("utf-8");

        //1.解析表单传递的数据
        String goodsNo = request.getParameter("goods_no");
        String brand1 = request.getParameter("brand");
        String type1 = request.getParameter("type");
        String price1 = request.getParameter("price");
        String info1 = request.getParameter("detail_info");
        String time1 = request.getParameter("time");



        //2.编写jdbc新增数据库
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet set = null;

        //响应代码
        response.setContentType("text/html; charset=utf-8");
        PrintWriter w = response.getWriter();

        try {
            //封装请求参数到对象中:
            Goods g1 = new Goods(0,goodsNo,brand1,type1,Double.valueOf(price1),info1,time1);

            //调用service层
            GoodsService goodsService = new GoodsServiceImpl();
            int r = goodsService.add(g1);

            if (r>0){
                //发布成功: 弹窗提醒并跳转
                w.write("<script>alert('商品发布成功了!'); location.href='/WebProject/query'</script>");
            }else {
                //发布失败: 弹窗提醒并跳转
                w.write("<script>alert('商品发布失败!'); location.href='/WebProject/add_goods.jsp'</script>");
            }
        } catch (Exception e) {
            w.write("<script>alert('商品发布操作异常,请重试!'); location.href='/WebProject/add_goods.jsp'</script>");

        }
        w.flush();
        w.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
