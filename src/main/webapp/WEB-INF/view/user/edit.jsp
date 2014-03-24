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
    <form id='user' method='post' action="${pageContext.request.contextPath}/user/update">
        <input type="hidden" name="id" value="${user.id}" />
        <table>
            <tr><td>Login Name:</td>
                <td><input name='loginName' id='loginName' value='${user.loginName}'/></td>
            </tr>
            <tr><td>Name:</td>
                <td><input name='name' id='name' value='${user.name}'/></td>
            </tr>
           <%-- <tr><td>Department:</td>
                <td><input name='department' id='department' value='${user.department}'/></td>
            </tr>--%>

        </table>
        <input type='submit' value="Update" id='update'/>
    </form>
</div>
</body>
</html>

