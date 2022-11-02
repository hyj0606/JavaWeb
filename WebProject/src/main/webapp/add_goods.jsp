<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hyj98
  Date: 2022-10-03
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js.js"></script>
</head>
<body>

    <form action="/WebProject/add" method="post"/>
        <p>
            商品编号:<input type="text" id="goods_no" name="goods_no" onblur="check1();" />
            <span class="goods_no_span"></span>
        </p>
        <p>
            品牌:<input type="text" name="brand"/>
        </p>
        <p>
            型号:<input type="text" name="type"/>
        </p>
        <p>
            价格:<input type="text" name="price"/>
        </p>
        <p>
            详细信息:<input type="text" name="detail_info"/>
        </p>
        <p>
            上市时间:<input type="text" name="time"/>
        </p>
        <p>
            <input type="submit" value="发布"/>
            <input type="button" value="返回" onclick="history.go(-1)"/>
        </p>
    </form>
</body>


    <script type="text/javascript">

        function check1(){

            //需求: 检查填写的商品编号在数据库中的唯一性...
            //要求: 给予jQuery框架中提供的ajax技术实现
            //1.先获取当前填写的商品编号
            var goods_no = $("#goods_no").val();
            console.log("获取到的商品编号为: "+goods_no);

            //2.ajax请求后台: 发送商品编号
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/checkGoodsNo",
                data: "goods_no="+goods_no,
                async: true,
                beforeSend: function (){
                    //请求前
                    console.log("准备请求后台....")
                },

                //3.监听返回结果.
                success: function ( r ){
                    //请求与响应成功: 根据返回值判定该编号是否已存在
                    if (r > 0){
                        //表示编号已存在:
                        $(".goods_no_span").text("该商品编号已存在,请重新填写!!");
                        $(".goods_no_span").css("color","red");
                    }else {
                        //表示编号允许使用,在数据表中不存在
                        $(".goods_no_span").text("该商品编号允许使用!!");
                        $(".goods_no_span").css("color","green");
                    }
                },
                error: function (){
                    //请求或响应失败:
                    alert("抱歉服务器忙,请稍后发布重试!!!")
                },
                complete: function (){
                    //请求后
                    console.log("请求后台已完成....")
                }

            });
        }
    </script>

</html>
