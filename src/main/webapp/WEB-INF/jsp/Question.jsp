<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New Test</title>
    <%@include file="/WEB-INF/jsp/parts/stylesandscripts.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="/WEB-INF/jsp/parts/header.jsp"%>

    <div class="mainblock">

<h3>Название вопроса:</h3>
<input type="text" id="questionField" name="question">
<p>
<h3>Ответы:</h3>
<table id="anserTable">
    <tbody>
    <tr><th>Ответ</th>
        <th></th></tr>
    <tr> <td><input type="text" id="answerTField0"></td> <td><input type="checkbox" id="answerChBox0"></td> </tr>
    <tr> <td><input type="text" id="answerTField1"></td> <td><input type="checkbox" id="answerChBox1"></td> </tr>
    </tbody>
</table>

<button class="add_answer">Добавить ответ</button>
<p>*Отметьте галочкой один или несколько правильных ответов</p>

<button class="addQuestion">Добавить вопрос</button>

        <form action="../">
            <input type="submit" value="Вернуться к вопросам">
        </form>
    </div>
    <%@include file="/WEB-INF/jsp/parts/footer.jsp" %>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        var sizeOfAnswers = 2;

        $('.add_answer').on('click', function () {
            var str = '<tr> <td><input type="text" id="answerTField' + sizeOfAnswers + '"></td> <td><input type="checkbox" id="answerChBox' + sizeOfAnswers + '"></td> </tr>';
            $("#anserTable").find('tbody')
                .append(str);
            sizeOfAnswers++;
        })

        $('.addQuestion').on('click', function () {

            var isCheckboxChecked = false;
            var answers = '';
            var rightanswers = '';


            for (var i = 0; i < sizeOfAnswers; i++) {
                if (document.getElementById("answerChBox" + i).checked) {
                    isCheckboxChecked = true;
                }
                else isCheckboxChecked = false;

                answers += document.getElementById("answerTField" + i).value + '\n';
                rightanswers += isCheckboxChecked + '\n';

            }
            var data = {
                titileOfQuestion: document.getElementById("questionField").value,
                answers: answers,
                rightanswers: rightanswers
            };
            $.ajax({

                type: 'POST',
                url: '../newquestion',
                data: data,

                success: function (data) {
                    alert('Поздравляем, вопрос успешно добавлен!');
                    window.location.href = "../"
                }
            });
        })

    });
</script>
</body>
</html>
