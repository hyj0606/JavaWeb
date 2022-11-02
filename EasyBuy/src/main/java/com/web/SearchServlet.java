package com.web;

import com.pojo.Page;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    /**
     * 商品分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productName = request.getParameter("productName");
        productName = productName == null ? "" : productName;

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
            ProductService productService = new ProductServiceImpl();
            Page page = productService.querySearchProduct( productName , pNo , pSize );

            //封装商品的分页查询地址,当前查询条件到page对象中:  随着page传递至页面中
            page.setUrl(request.getContextPath()+"/SearchServlet"); //给商品的分页查询地址
            page.setCondition("&productName="+productName); //给商品的分页查询条件

            //3.借助域对象存储: 查询结果.  方便传递至下一个资源页面上
            request.setAttribute("page",page);
            request.setAttribute("productName",productName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //4.跳转至下一个资源页面中显示即可.
        request.getRequestDispatcher("/BrandList.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
