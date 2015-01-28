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



        <table class="table table-striped table-bordered table-condensed">
            <thead>
            <tr>
                <th>Id</th>
                <th>名称</th>
                <th>分类</th>
                <th>部署时间</th>
                <th>操作</th>

            </tr>
            </thead>
            <c:forEach items='${deploymentPage.content}' var='deployment'>
                <tr>
                    <td>${deployment.id}</td>
                    <td>${deployment.name}</td>
                    <td>${deployment.category}</td>
                    <td>${deployment.deploymentTime}</td>
                    <td>
                        <div class="btn-group">
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/user/view?id='>View</a>
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/user/edit?id='>Edit</a>
                            <a class="btn btn-default"
                               href='${pageContext.request.contextPath}/workflow/deployment/delete?id=${deployment.id}'>Delete</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <tags:pagination page="${deploymentPage}" />

</body>
</html>