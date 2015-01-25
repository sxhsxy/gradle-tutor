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
    <title>系统用户</title>
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
<%--        <div class="col-sm-offset-0 col-sm-3">${userPage.size*userPage.number + 1}  - ${userPage.number < userPage.totalPages -1 ? userPage.size*(userPage.number + 1) : userPage.totalElements}条，共${userPage.totalElements}条</div>
        <div class="col-sm-offset-1 col-sm-4">
            <c:choose>

                <c:when test="${userPage.number != 0}">
                    <a href="javascript:loadPageNumber(1)"><span class="glyphicon glyphicon-step-backward"></span></a>
                    <a href="javascript:loadPageNumber(${userPage.number})"><span class="glyphicon glyphicon-chevron-left"></span></a>
                </c:when>

                <c:otherwise>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-step-backward"></span></span>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-chevron-left"></span></span>
                </c:otherwise>

            </c:choose>

            第<input id="pageNumber" type="text" size="2" maxlength="7" value="${userPage.number + 1}"/> 页，共 <span id="sp_1_pager">${userPage.totalPages}</span> 页

            <c:choose>

                <c:when test="${userPage.number < userPage.totalPages -1}">
                    <a href="javascript:loadPageNumber(${userPage.number+2})"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    <a href="javascript:loadPageNumber(${userPage.totalPages})"><span class="glyphicon glyphicon-step-forward"></span></a>
                </c:when>

                <c:otherwise>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-chevron-right"></span></span>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-step-forward"></span></span>
                </c:otherwise>

            </c:choose>

        </div>
        <div class="col-sm-offset-2 col-sm-2">
            每页 <input id="pageSize" type="text" size="2" maxlength="7" value="${userPage.size}"/> 条
            <a id="refresh"><span class="glyphicon glyphicon-refresh"></span></a>
        </div>--%>

</body>
</html>