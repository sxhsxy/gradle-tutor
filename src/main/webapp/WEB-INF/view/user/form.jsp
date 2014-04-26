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
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='sf' uri='http://www.springframework.org/tags/form' %>
<html>
<head>
    <title>User</title>
    <link href="${pageContext.request.contextPath}/include/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/include/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/include/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>

</head>
<body>
<div class="container">
<ul class="nav nav-tabs">
    <li><a href="${pageContext.request.contextPath}/user">User List</a></li>
    <li class="active"><a href="${pageContext.request.contextPath}/user/new">Create User</a></li>
</ul>
<br/>
<div id='list'>
    <sf:form modelAttribute="user" method='post' class="form-horizontal"
             action="${pageContext.request.contextPath}/user/update">
        <sf:hidden path="id"/>
        <div class="form-group">
            <label class="col-sm-2 control-label">Username</label>

            <div class="col-sm-9">
                <sf:input path="loginName" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Password</label>

            <div class="col-sm-9">
                <input type="password" name="password" value="" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Full Name</label>

            <div class="col-sm-9">
                <sf:input path="name" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Department</label>

            <div class="col-sm-9">
                <sf:select path="department" items="${departmentList}" itemValue="id" itemLabel="name"
                           class="form-control"/>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-1">
                <input type="submit" class="btn btn-default" value="Save" />
            </div>
            <div class="col-sm-1">
                <input type="button" class="btn btn-default" value="Cancel" />
            </div>
        </div>

    </sf:form>
</div>
</div>
</body>
</html>
