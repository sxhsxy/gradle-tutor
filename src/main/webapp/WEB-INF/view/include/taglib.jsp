<%--<%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix='sf' uri='http://www.springframework.org/tags/form' %>
<%--<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}${fns:getAdminPath()}"/>--%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}"/>