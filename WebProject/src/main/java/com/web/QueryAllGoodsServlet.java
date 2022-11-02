package com.web;

import com.pojo.Page;
import com.service.GoodsService;
import com.service.impl.GoodsServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/query")
public class QueryAllGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        String goods_name = request.getParameter("goods_name");
        goods_name = goods_name == null ? "" : goods_name;

        //1.明确查询页码
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");

        try {
            //检查请求参数:
            int pNo = 1;
            if (pageNo != null && !pageNo.equals("")) {
                //采用客户请求的页码
                pNo = Integer.valueOf(pageNo);
            }
            int pSize = 5;
            if (pageSize != null && !pageSize.equals("")) {
                //采用客户请求的页码
                pSize = Integer.valueOf(pageSize);
            }

            //调用service层:
            GoodsService goodsService = new GoodsServiceImpl();
            Page page = goodsService.queryAllGoods( goods_name , pNo , pSize );

            //封装商品的分页查询地址,当前查询条件到page对象中:  随着page传递至页面中
            page.setUrl("/WebProject/query"); //给商品的分页查询地址
            page.setCondition("&goods_name="+goods_name); //给商品的分页查询条件

            //3.借助域对象存储: 查询结果.  方便传递至下一个资源页面上
            request.setAttribute("page",page);
            request.setAttribute("goods_name",goods_name);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //4.跳转至下一个资源页面中显示即可.
        request.getRequestDispatcher("/goods_list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
