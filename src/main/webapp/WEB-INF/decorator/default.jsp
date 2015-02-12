<%--
  Created by IntelliJ IDEA.
  User: Xiaohu
  Date: 15-1-16
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/view/include/taglib.jsp"%>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <%@include file="/WEB-INF/view/include/head.jsp" %>
    <sitemesh:write property='head'/>
</head>
<body class="skin-blue">
<%@include file="/WEB-INF/view/include/header.jsp" %>
<div class="wrapper row-offcanvas row-offcanvas-left">
    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="/WEB-INF/view/include/sidebar.jsp" %>
    <aside class="right-side">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            <sitemesh:write property='title'/>
            <small>Description</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>

    <!-- Main content -->
    <section class="content">

        <sitemesh:write property='body'/>

    </section><!-- /.content -->
    </aside><!-- /.right-side -->
大家好

    </div>
</body>
</html>
