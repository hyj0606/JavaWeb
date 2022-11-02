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

    <style type="text/css">
        table{
            width: 100%;
            height: 300px;
        }

        td{
            border: 2px gray solid;
        }

    </style>

</head>
<body>
    <p>
        欢迎:${login_user.username}来到系统后台<a href="/WebProject/logout">退出</a>
    </p>
    <p>
        <button onclick="location.href='/WebProject/add_goods.jsp'">发布新商品</button>

        <form action="/WebProject/query" method="get">
            输入商品名称: <input type="text" name="goods_name" value="${goods_name}" /> <input type="submit" value="查询"/>
        </form>

    </p>
    <table>
        <tr>
            <td>编号</td>
            <td>品牌</td>
            <td>类型</td>
            <td>价格</td>
            <td>详细参数</td>
            <td>发布日期</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty page.list}">
            <tr>
                <td colspan="7" style="text-align: center"> 抱歉没有查询到相关商品!!! </td>
            </tr>
        </c:if>

        <c:if test="${!empty page.list}">
            <c:forEach var="g1" items="${page.list}">

                <tr>
                    <td>${g1.id}</td>
                    <td>${g1.brand}</td>
                    <td>${g1.type}</td>
                    <td>${g1.price}</td>
                    <td>${g1.detailInfo}</td>
                    <td>${g1.releaseTime}</td>
                    <td>
                        <button onclick="isDel('${g1.id}');"> 删除 </button>
                        <button onclick="edit('${g1.id}');"> 修改 </button>
                    </td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <%--分页页码抽取至page.jsp中,充当分页插件使用. 实现引用:--%>
    <%@include file="page.jsp"%>


    <script type="text/javascript">

        function isDel(goodsId){

            var r = confirm("确认删除编号为"+goodsId+"的商品吗?");
            if (r){
                //发起删除,并传递需要删除的商品编号.
                location.href="/WebProject/del?gid="+goodsId;
            }

        }

        function edit(goodsId){

            //修改界面跳转
            location.href = "/WebProject/toEdit?gid="+goodsId;

        }

    </script>


</body>
</html>
