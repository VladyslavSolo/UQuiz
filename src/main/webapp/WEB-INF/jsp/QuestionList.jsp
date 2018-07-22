<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz List</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp" %>
    <div class="mainblock">
        <table>
            <c:forEach items="${list}" var="question">
                <tr>
                    <td> ${question.getId()}.</td>
                    <td><b> ${question.getQuestion()} </b></td>
                    <td><a href="removequestion/${question.getId()}" content=" ">Delete</a></td>
                </tr>
                <td><c:forEach items="${question.answer}" var="answer">
                    <p><input name=rgroup${question.getId()} type="radio" value=value${question.getId()}> ${answer}</p>
                </c:forEach></td>
            </c:forEach>
        </table>
        <p>
        <form action="newquestion/" method="get">
            <input type="submit" value="Добавить вопрос">
        </form>
        </p>
    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>
</body>
</html>
