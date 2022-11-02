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

@WebServlet("/toEdit")
public class ToEditGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        //请求参数乱码
//        request.setCharacterEncoding("utf-8");

        //1.解析表单传递的数据
        String gid = request.getParameter("gid");

        //响应代码
        response.setContentType("text/html; charset=utf-8");
        PrintWriter w = response.getWriter();

        try {

            //根据service层查询结果判定:
            GoodsService goodsService = new GoodsServiceImpl();
            Goods g1 = goodsService.queryGoodsById(Long.valueOf(gid));

            if (g1 != null){
                //借助request请求对象传递数据至下一个视图界面上:
                request.setAttribute("g1",g1);
                request.getRequestDispatcher("/edit_goods.jsp").forward(request,response);

            }else {
                w.write("<script>alert('商品修改参数有误,请重试!'); location.href='/WebProject/query.jsp'</script>");
            }

        } catch (Exception e) {
            w.write("<script>alert('商品修改操作异常,请重试!'); location.href='/WebProject/query'</script>");

        }
        w.flush();
        w.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
