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
    <h2 style="color: red">${errorMsg}</h2>
    <form action="/WebProject/login" method="post"/>
        <p>
            账号:<input type="text" name="username"/>
        </p>
        <p>
            密码:<input type="password" name="password"/>
        </p>
        <p>
            <input type="submit" value="登录"/>
        </p>
    </form>


</body>
</html>
