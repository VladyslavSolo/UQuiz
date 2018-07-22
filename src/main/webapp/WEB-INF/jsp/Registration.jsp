<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Регистрация</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>

    <div class="mainblock">
        <center>
            <h2>Зарегистрироваться</h2>
            <form:form action="/reg" method="post" modelAttribute="userReg">
            <table>
                <tr>
                    <td><form:label path="login">Введите логин:</form:label></td>
                    <td><form:input class="form-control" path="login"/></td>
                    <td> <form:errors path="login"/></td>
                </tr>
                <tr>
                    <td><label/>
                </tr>
                <tr>
                    <td><form:label path="password">Введите пароль: </form:label></td>
                    <td><form:input class="form-control" path="password"/></td>
                    <td> <form:errors path="password"/></td>
                </tr>
                <tr>
                </tr>
            </table>
            <p>
            <p><button class="btn btn-lg btn-primary" type="submit">Зарегистрироваться</button>

                </form:form>
        </center>
    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>
</body>
</html>
