<%--
  Created by IntelliJ IDEA.
  User: xiaohu
  Date: 14-3-20
  Time: 下午9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>

<html>
<head>
    <title>流程部署</title>
</head>
<body>


    <ul class="nav nav-tabs">
        <li class="active"><a href="${pageContext.request.contextPath}/user">User List</a></li>
        <li><a href="${pageContext.request.contextPath}/user/new">Create User</a></li>
    </ul>

        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <th>Name</th>
                <th>Department</th>
                <th>Operations</th>

            </tr>
            </thead>
            <c:forEach items='${userPage.content}' var='user'>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.department.name}</td>
                    <td>
                        <div class="btn-group">
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/user/view?id=${user.id}'>View</a>
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/user/edit?id=${user.id}'>Edit</a>
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/user/delete?id=${user.id}'>Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <tags:pagination page="${userPage}" />
</body>
</html>