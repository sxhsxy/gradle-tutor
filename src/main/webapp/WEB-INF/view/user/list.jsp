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
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='sf' uri='http://www.springframework.org/tags/form'%>

<html>
<head>
    <title>Users</title>
    <link rel='stylesheet' href='' type='text/css'>
</head>
<body>
<h1>List of users</h1>
<a href='${pageContext.request.contextPath}/user/new'>Add new user</a>
<table cellspacing='1' border="1" class='main-table'>
    <tr>
        <th>Name</th>
        <th>Department</th>
        <th>Details</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${users}' var='user'>
        <tr>
            <td>${user.name}</td>
            <td>${user.department}</td>
            <td>
                <a href='${pageContext.request.contextPath}/user/view?id=${user.id}'>View</a>
            </td>
            <td>
                <a href='${pageContext.request.contextPath}/user/delete?id=${user.id}'>Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br />
<a href='welcome'>Go back</a>
</body>
</html>