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

</head>
<body>

    <form id="form1" action="/WebProject/save" method="post"/>
        <p>
            编号:<input type="text" name="id" value="${g1.id}" readonly="readonly"/> <%--只读--%>
        </p>
        <p>
            商品编号:<input type="text" name="goods_no" value="${g1.goodsNo}" />
        </p>
        <p>
            品牌:<input type="text" name="brand" value="${g1.brand}"/>
        </p>
        <p>
            型号:<input type="text" name="type" value="${g1.type}"/>
        </p>
        <p>
            价格:<input type="text" name="price" value="${g1.price}"/>
        </p>
        <p>
            详细信息:<input type="text" name="detail_info" value="${g1.detailInfo}"/>
        </p>
        <p>
            上市时间:<input type="text" name="time" value="${g1.releaseTime}"/>
        </p>
        <p>
            <input type="button" value="保存" onclick="ajaxSumit();" />
            <input type="button" value="返回" onclick="history.go(-1)"/>
        </p>
    </form>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js.js"></script>
    <script type="text/javascript">

        function ajaxSumit(){

            //需求： 借助Ajax实现表单提交

            //1.解析表单数据
            var str = $("#form1").serialize();
            console.log("表单数据为: "+str);

            //2.编写Ajax请求
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/save",
                data: str,
                async: true,

                //3.监听返回结果.
                success: function ( r ){
                    //请求与响应成功: 根据返回值判定该修改是否完成
                    if (r > 0){
                        //表示保存成功:
                        alert("恭喜.修改保存成功!!")
                        location.href="${pageContext.request.contextPath}/query"/*类似重定向*/
                    }else {
                        //表示保存失败:
                        alert("抱歉,您修改的参数有误,请重试!!")
                    }
                },
                error: function (){
                    //请求或响应失败:
                    alert("抱歉服务器忙,请稍后发布重试!!!")
                }

            });

            //3.响应成功或失败,给与跳转.

        }

    </script>

</body>
</html>
