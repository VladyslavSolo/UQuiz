<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>

    <div class="mainblock"> <center>

        <form class="form-auth" method="post" action="/auth">
            <h2 class="form-signin-heading">Пожалуйста авторизируйтесь</h2>
            <table>

                <td> <input type="text" class="form-control"  placeholder="Введите логин" name="login"></td>

                <tr>
                    <td><input type="password" class="form-control" placeholder="Введите пароль" name="password"></td>
                </tr>
            </table>
            <p><p><button class="btn btn-lg btn-primary" type="submit">Авторизироваться</button></p>
        </form>

        <p>Не создали аккаунт?
            <a href="/reg">Зарегистрироваться</a>

    </center> </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>
</body>
</html>
