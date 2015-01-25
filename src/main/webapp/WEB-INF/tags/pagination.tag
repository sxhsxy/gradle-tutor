<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
//System.out.println(page);
%>
<div>

        <div class="col-sm-offset-0 col-sm-3">${page.size*page.number + 1}  - ${page.number < page.totalPages -1 ? page.size*(page.number + 1) : page.totalElements}条，共${page.totalElements}条</div>
        <div class="col-sm-offset-1 col-sm-4">
            <c:choose>

                <c:when test="${page.number != 0}">
                    <a href="javascript:loadPageNumber(1)"><span class="glyphicon glyphicon-step-backward"></span></a>
                    <a href="javascript:loadPageNumber(${page.number})"><span class="glyphicon glyphicon-chevron-left"></span></a>
                </c:when>

                <c:otherwise>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-step-backward"></span></span>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-chevron-left"></span></span>
                </c:otherwise>

            </c:choose>

            第<input id="pageNumber" type="text" size="2" maxlength="7" value="${page.number + 1}"/> 页，共 <span id="sp_1_pager">${page.totalPages}</span> 页

            <c:choose>

                <c:when test="${page.number < page.totalPages -1}">
                    <a href="javascript:loadPageNumber(${page.number+2})"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    <a href="javascript:loadPageNumber(${page.totalPages})"><span class="glyphicon glyphicon-step-forward"></span></a>
                </c:when>

                <c:otherwise>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-chevron-right"></span></span>
                    <span  style="color: rgb(160, 160, 160);"><span class="glyphicon glyphicon-step-forward"></span></span>
                </c:otherwise>

            </c:choose>

        </div>
        <div class="col-sm-offset-2 col-sm-2">
            每页 <input id="pageSize" type="text" size="2" maxlength="7" value="${page.size}"/> 条
            <a id="refresh"><span class="glyphicon glyphicon-refresh"></span></a>
        </div>
    <script>
        <%--$(document).load(insertPagination("pageNoDisplay", 3, ${userPage.size}, ${userPage.number}, ${userPage.totalPages}));--%>
        $("#pageNumber").keydown(function(e) {
            if(e.keyCode==13)loadPageDefault();
        });
        $("#pageSize").keydown(function(e) {
            if(e.keyCode==13)loadPageDefault();
        });
        $("#refresh").click(loadPageDefault);
        function loadPageDefault() {
            var pageNumber = $("#pageNumber").val();
            loadPageNumber(pageNumber);
        }
        function loadPageNumber(pagenumber) {
            location = location.pathname + "?pageNumDisplay=" + pagenumber + "&pageSize=" + $("#pageSize").val();
        }
    </script>
</div>