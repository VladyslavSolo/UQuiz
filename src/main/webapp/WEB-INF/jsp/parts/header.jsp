<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<meta charset="windows-1251">
<div class="header">

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">UQuiz</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/quizlist">All quizzes</a></li>
            <sec:authorize access="hasAnyAuthority('ADMIN','SUPERADMIN')">
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">for admin<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/admin/acclist">All users</a></li>
                </ul>
            </li>
            </sec:authorize>
        </ul>
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/auth"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <li><a href="/reg"><span class="glyphicon glyphicon-plus"></span> Registration</a></li>
            </ul>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <ul class="nav navbar-nav navbar-right">
            <li><a><span class="glyphicon glyphicon-user"></span> <sec:authentication property="principal.username"/></a></li>
             <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
         </ul>
        </sec:authorize>

     </div>
 </nav>
 </div>