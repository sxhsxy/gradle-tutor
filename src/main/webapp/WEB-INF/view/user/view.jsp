<%--
  Created by IntelliJ IDEA.
  User: xiaohu
  Date: 14-3-22
  Time: 下午10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ taglib prefix='sf' uri='http://www.springframework.org/tags/form'%>
<html>
<head>
    <title>User</title>
</head>
<body>
<h1>User Details</h1>
<h2>${user.name}</h2>
<div id='list'>
    <form id='user' method='post' action="user/update">
        <table>
            <tr><td>Login Name:</td>
                <td><input name='loginName' id='loginName' value='${user.loginName}' disabled='true'/></td>
            </tr>
            <tr><td>Name:</td>
                <td><input name='name' id='name' value='${user.name}' disabled='true'/></td>
            </tr>
            <tr><td>Department:</td>
                <td><input name='department' id='department' value='${user.department}' disabled='true'/></td>
            </tr>

        </table>

        <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">Edit</a>
    </form>
</div>
</body>
</html>
