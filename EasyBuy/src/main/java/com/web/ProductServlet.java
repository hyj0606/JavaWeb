package com.web;

import com.pojo.BuyCar;
import com.pojo.Page;
import com.pojo.Product;
import com.pojo.ProductCategory;
import com.service.OrderService;
import com.service.ProductService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    /**
     * 商品详情分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //进行分页展示
        //查询改商品类型的全部商品
        String id = request.getParameter("id");
        //1.明确查询页码
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");

        //检查请求参数
        int pNo = 1;
        if (pageNo != null && !pageNo.equals("")){
            //采用客户请求的页码
            pNo = Integer.valueOf(pageNo);
        }
        int pSize = 5;
        if (pageSize != null && !pageSize.equals("")){
            pSize = Integer.valueOf(pageSize);
        }

        //查询所有订单商品---->service层
        ProductService productService = new ProductServiceImpl();
        Page page = productService.queryAllProduct(Integer.valueOf(id), pNo,pSize );

        //封装商品的分页查询地址,当前地址查询条件到page对象中: 随着page传递至页面中
        page.setUrl(request.getContextPath()+"/productServlet");  //给商品的分页查询地址
        page.setCondition("&id="+id); //给商品的分页查询条件

        //2.将获得结果传递给视图
        request.setAttribute("page",page);
        request.setAttribute("id",id);

        //购物车
        List<BuyCar> buyCarList = productService.queryBuyCar();
        HttpSession session = request.getSession();
        session.setAttribute("buyCarList",buyCarList);

        //转发到BrandList.jsp
        request.getRequestDispatcher("/BrandList.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
