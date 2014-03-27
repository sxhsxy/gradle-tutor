<%--
  Created by IntelliJ IDEA.
  User: xiaohu
  Date: 14-3-20
  Time: 下午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='sf' uri='http://www.springframework.org/tags/form' %>

<html>
<head>
    <title>Users</title>
    <link rel='stylesheet' href='' type='text/css'>
    <link href="http://cdn.bootcss.com/bootstrap/3.1.1/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdn.bootcss.com/jquery/2.0.3/jquery.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.1.1/js/bootstrap.js"></script>
</head>
<body>
<div class="container">

    <div class=""><h1>List of users</h1></div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Operations</th>

            </tr>
            </thead>
            <c:forEach items='${users}' var='user'>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.department}</td>
                    <td>
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/view?id=${user.id}'>View</a>
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/edit?id=${user.id}'>Edit</a>
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/delete?id=${user.id}'>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <div class="col-md-2" >
            <a class="btn btn-default" href='${pageContext.request.contextPath}/user/new'>Add a new user</a>
        </div>
    </div>
</div>
</body>
</html>