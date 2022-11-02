<%--
  Created by IntelliJ IDEA.
  User: hyj98
  Date: 2022-10-05
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p style="text-align: center;">

    <a href="${page.url}?pageNo=1${page.condition}">首页</a>
    <a href="${page.url}?pageNo=${page.pageNo==1?1:page.pageNo-1}${page.condition}">上一页</a>

    <c:forEach var="pNum" begin="1" end="${page.totalPage}">

        <c:if test="${pNum==page.pageNo}">
            <a href="javascript: void(0); ">${pNum}</a>
        </c:if>

        <c:if test="${pNum!=page.pageNo}">
            <a href="${page.url}?pageNo=${pNum}${page.condition}">${pNum}</a>
        </c:if>

    </c:forEach>

    <a href="${page.url}?pageNo=${page.pageNo==page.totalPage?page.totalPage:page.pageNo+1}${page.condition}">下一页</a>
    <a href="${page.url}?pageNo=${page.totalPage}${page.condition}">尾页</a>

</p>

