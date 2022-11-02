package com.web;

import com.pojo.User;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //当前控制器:

        //请求参数乱码:
        request.setCharacterEncoding("utf-8");

        //1.解析表单传递的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用Service层:
        UserServiceImpl userService = new UserServiceImpl();
        User u1 = userService.login(username,password);

        if (u1 != null){
            //登录成功: 存储身份至会话对象中
            HttpSession session = request.getSession();
            session.setAttribute("login_user",u1);

            //跳往后台: /WebProject/query
            response.sendRedirect("/WebProject/query");
        }else {
            //登录失败: 账号或密码错误
            request.setAttribute("errorMsg","登录失败,可能账号密码错误,请重试");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

//        //2.编写jdbc新增数据库
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet set = null;
//
//        //响应代码
//        response.setContentType("text/html; charset=utf-8");
//        PrintWriter w = response.getWriter();
//
//        try {
//            //1.加载驱动
//            //2.建立连接: 通过Jdbc工具类即可
//            conn = JdbcUtil.getConnection();
//            //3.编写sql
//            String sql = "select * from tb_user where username=?";
//
//            //4.创建一个预编译执行对象,先绑定参数与,在执行sql
//            pstm = conn.prepareStatement(sql);
//
//            //绑定参数:
//            pstm.setString(1,username);
//
//            //set即为查询结果: 临时数据表
//            set = pstm.executeQuery();
//
//            //查询到信息: 表示账号存在
//            if (set.next()){
//
//                long id = set.getLong("id");
//
//                //检查密码是否正确
//                String pwd = set.getString("password");
//
//                if (pwd.equals(password)){
//                    //登录成功: 存储身份至会话中
//                    User u1 = new User();
//                    u1.setId(id);
//                    u1.setUsername(username);
//
//                    //u1.setPassword(password); 无需暴露密码在登录的身份对象中
//
//                    HttpSession session = request.getSession();
//                    session.setAttribute("login_user",u1);
//
//                    //眺望后台: /WebProject/query
//                    response.sendRedirect("/WebProject/query");
//
//                }else {
//                    //密码错误
//                    request.setAttribute("errorMsg","登录失败,密码错误,请重新填写!!!");
//                    request.getRequestDispatcher("/login.jsp").forward(request,response);
//                }
//            }else {
//                //表示未查询到数据,账号不存在
//                request.setAttribute("errorMsg","登录失败,账号不存在,请重新填写!!!");
//                request.getRequestDispatcher("/login.jsp").forward(request,response);
//            }
//
//        } catch (SQLException e) {
//            request.setAttribute("errorMsg","登录异常,请重新填写!!!");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }finally {
//            //必须操作
//            //6.释放资源
//            JdbcUtil.closeResource(set,pstm,conn);
//        }
//        w.flush();
//        w.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
