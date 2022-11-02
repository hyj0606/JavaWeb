package com.web;

import com.pojo.BuyCar;
import com.pojo.New;
import com.pojo.Product;
import com.pojo.ProductCategory;
import com.service.NewService;
import com.service.ProductCategoryService;
import com.service.ProductService;
import com.service.impl.NewServiceImpl;
import com.service.impl.ProductCategoryServiceImpl;
import com.service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/pCServlet")
public class ProductCategoryServlet extends HttpServlet {

    /**
     * 首页: 三级标题的展示,新闻模块的展示
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductCategoryService pCService = new ProductCategoryServiceImpl();
        List<ProductCategory> pcList = pCService.queryAll();

        for (int i = 0; i < pcList.size(); i++) {

            List<ProductCategory> pcTwoList = pCService.queryTwoAll(pcList.get(i).getId());

            for (int j = 0; j < pcTwoList.size(); j++) {
                List<ProductCategory> pcThreeList = pCService.queryThreeAll(pcTwoList.get(j).getId());
                pcTwoList.get(j).setLevel(pcThreeList);
            }
            pcList.get(i).setLevel(pcTwoList);
        }

        HttpSession session = request.getSession();
        session.setAttribute("pcList",pcList);

        NewService newService = new NewServiceImpl();
        List<New> newList = newService.queryAll();
        request.setAttribute("newList",newList);

        request.getRequestDispatcher("/Index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
