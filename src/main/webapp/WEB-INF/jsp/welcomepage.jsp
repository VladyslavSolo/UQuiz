<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>Поздравляем!</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
    <style>
        h3 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>

    <div class="mainblock">
        <h3><%=session.getAttribute("login")%> <spring:message code="welcomepage.congratulation"/>

        </h3>
    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>
</body>
</html>
