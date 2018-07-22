<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Quiz List</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>

    <div class="mainblock">

        <!--New quiz -->
        <sec:authorize access="hasAnyAuthority('ADMIN','SUPERADMIN','USER')">
            <h3>Создать новый опрос!</h3>
            <form:form action="/quizlist" method="post" modelAttribute="quizToAdd">
                <div class="form-group">
                    <form:label path="name" for="namequiz">Название опроса: <form:errors path="name"/>
                    </form:label>
                    <form:input path="name" type="text" class="form-control" id="namequiz"/>
                </div>
                <div class="form-group">
                    <form:label path="objective" for="objectivequiz">Предметная область: <form:errors path="objective"/>
                    </form:label>
                    <form:input path="objective" type="text" class="form-control" id="objectivequiz"/>
                </div>
                <input type="submit" value="Создать опрос">
            </form:form>
        </sec:authorize>

        <!--quiz list -->
        <table class="table_quiz">
            <caption/>
            <tbody>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Objective</th>
                <th>Creator</th>
                <th/>
            </tr>
            <c:forEach items="${list}" var="test">
                <tr>
                    <input type="hidden" name="table_id" value="${test.getId()}"/>
                    <td> ${test.getId()}</td>
                    <td>
                        <a href="quiz/${test.getId()}/">${test.getName()}</a>
                    </td>
                    <td> ${test.getObjective()} </td>
                    <td> ${test.getCreator().getLogin()} </td>
                    <td class="deleteRow">Delete</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".deleteRow").click(function (evt) {
            var selectId = $(this).closest("tr").find("[name='table_id']").val();

            $.ajax({
                type: 'DELETE',
                url: "quizlist/" + selectId,
                success: function () {
                    if (evt.target.closest('.deleteRow')) {
                        evt.target.closest('tr').remove()
                    }
                }
            })
        });
    });

</script>

</body>
</html>
