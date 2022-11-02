<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<h2 style="text-align: center;">
  <a href="${page.url}?pageNo=1${page.condition}">首页</a>

  <a href="${page.url}?pageNo=${page.pageNo<=1?1:page.pageNo-1}${page.condition}">上一页</a>

  <c:forEach var="p" begin="1" end="${page.totalPage}">
    <a href="${page.url}?pageNo=${p}${page.condition}">${p}</a>
  </c:forEach>

  <a href="${page.url}?pageNo=${page.pageNo>=page.totalPage?page.totalPage:page.pageNo+1}${page.condition}">下一页</a>

  <a href="${page.url}?pageNo=${page.totalPage}${page.condition}">尾页</a>
</h2>
