<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>All users</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>
    <div class="mainblock">
        <h3>Все пользователи сайта:</h3>
        <table class="table">
            <caption/>
            <tbody>
            <tr>
                <th>id</th>
                <th>login</th>
                <th>email</th>
                <th>role</th>
                <th>action</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td class="current-role">${user.role}</td>
                    <td>
                        <form class="changeRoleForm">
                            <label> Изменить роль на: </label>
                            <select class="role" name="role">
                                <c:forEach items="${roles}" var="role">
                                    <option value="${role.name()}">${role}</option>
                                </c:forEach>
                            </select>
                            <input type="hidden" name="id" class="id" value="${user.id}">
                            <input type="submit" value="Изменить роль">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>

<script type="text/javascript">
    $('form.changeRoleForm').on('submit', function (e) {
        e.preventDefault();
        var form =$(this);
        var role =form.children("select.role").val();
        var    id=form.children("input.id").val();

        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: 'changerole?role='+role+'&id='+id,

            success: function (response) {
                var tableline=form.parent().parent();
                alert(response.message);
                tableline.css("background-color", "#98FB98");
                tableline.children("td.current-role").html(role);
            },
            error: function (xmlHttpRequest, textStatus, errorThrown) {
                if (xmlHttpRequest.readyState == 0 || xmlHttpRequest.status == 0)
                    return;
                else {
                    var tableline=form.parent().parent();
                    alert("Something went wrong. Role not updated");
                    tableline.css("background-color", "#FA8072");

                }
            }
        });
    });
</script>

</body>
</html>
