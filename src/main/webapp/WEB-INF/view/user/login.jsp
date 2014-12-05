<%--
  Created by IntelliJ IDEA.
  User: Xiaohu
  Date: 14-4-24
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/include/jquery.min.js"></script>

    <script src="../js/bootstrap.js"></script>

</head>
<body>
<div class="container">
    <h1>Login</h1>
    <div  class="col-md-6">
        <form method="post" action="${pageContext.request.contextPath}/user/login">
            <label>用户名</label>

            <input type="text" name="loginName" value=""/>
            <input type="password" name="password" />
            <input type="submit"/>
            <a href="#"  class="btn btn-default">AAA</a>

        </form>

    </div>
</div>

</body>
</html>
