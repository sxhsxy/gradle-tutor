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
    <link href="${pageContext.request.contextPath}/include/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/include/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/include/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>


</head>
<body>
<div class="container">

    <ul class="nav nav-tabs">
        <li class="active"><a href="${pageContext.request.contextPath}/user" >User List</a></li>
        <li><a href="${pageContext.request.contextPath}/user/new">Create User</a></li>
    </ul>
    <div class="row">
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
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/view?id=${user.id}'>View</a>
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/edit?id=${user.id}'>Edit</a>
                        <a class="btn btn-default" href='${pageContext.request.contextPath}/user/delete?id=${user.id}'>Delete</a>
                    </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-sm-offset-7 col-sm-5">
        <ul id="pagination" class="pagination">
        </ul>


    </div>


</div>
<script>
    $(document).load(insertPagination("pageNoDisplay", 3, ${userPage.size}, ${userPage.number}, ${userPage.totalPages}));
</script>
</body>
</html>