package com.web;

import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/del")
public class DelGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        //请求参数乱码
        request.setCharacterEncoding("utf-8");

        //1.解析表单传递的数据
        String gid = request.getParameter("gid");


        //响应代码
        response.setContentType("text/html; charset=utf-8");
        PrintWriter w = response.getWriter();

        try {

            //调用service层
            GoodsService goodsService = new GoodsServiceImpl();
            int r = goodsService.del(Long.valueOf(gid));

            if (r>0){
                //发布成功: 弹窗提醒并跳转
                w.write("<script>alert('商品删除成功了!'); location.href='/WebProject/query'</script>");
            }else {
                //发布失败: 弹窗提醒并跳转
                w.write("<script>alert('商品删除失败!'); location.href='/WebProject/query'</script>");
            }
        } catch (Exception e) {
            w.write("<script>alert('商品发布操作异常,请重试!'); location.href='/WebProject/query'</script>");

        }
        w.flush();
        w.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
