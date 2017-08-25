<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Матч центр</title>


    <style type="text/css">


        /* table design */
        @import url(http://fonts.googleapis.com/css?family=Lato);

        h1 {
            font-size: 30px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 300;
            text-align: center;
            margin-bottom: 15px;
        }

        h2 {
            font-size: 24px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 300;
            text-align: center;
            margin-bottom: 15px;
        }

        table {
            width: 100%;
            table-layout: fixed;
        }

        .tbl-header {
            background-color: rgba(200, 255, 255, 0.3);
            text-align: center;
        }

        .tbl-content {
            height: 500px;
            overflow-x: auto;
            margin-top: 0px;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        th {
            padding: 20px 15px;
            text-align: left;
            font-weight: 800;
            font-size: 13.5px;
            color: #fff;
            text-transform: uppercase;
        }

        td {
            padding: 15px;
            text-align: left;
            vertical-align: middle;
            font-weight: 450;
            font-size: 12.5px;
            color: #fff;
            border-bottom: solid 1px rgba(255, 255, 255, 0.1);
        }

        /* demo styles */

        @import url(http://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
        body {
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4);
            font-family: 'Roboto', sans-serif;
        }

        section {
            margin: 50px;
        }

        /* for custom scrollbar for webkit browser*/

        ::-webkit-scrollbar {
            width: 6px;
        }

        ::-webkit-scrollbar-track {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
        }

        ::-webkit-scrollbar-thumb {
            -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
        }

        /*| Navigation menu |*/

        *, *:before, *:after {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 0;
            margin: 0;
            font-family: 'Lato', sans-serif;
        }

        nav {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background: #05a489;
            box-shadow: 0 3px 10px -2px rgba(0, 0, 0, .1);
            border: 1px solid rgba(0, 0, 0, .1);
        }

        nav ul {
            list-style: none;
            position: relative;
            float: right;
            margin-right: 100px;
            display: inline-table;
        }

        nav ul li {
            float: left;
            -webkit-transition: all .2s ease-in-out;
            -moz-transition: all .2s ease-in-out;
            transition: all .2s ease-in-out;
        }

        nav ul li:hover {
            background: rgba(0, 0, 0, .15);
        }

        nav ul li:hover > ul {
            display: block;
        }

        nav ul li {
            float: left;
            -webkit-transition: all .2s ease-in-out;
            -moz-transition: all .2s ease-in-out;
            transition: all .2s ease-in-out;
        }

        nav ul li a {
            display: block;
            padding: 30px 20px;
            color: #ffffff;
            font-size: .9em;
            letter-spacing: 1px;
            text-decoration: none;
            text-transform: uppercase;
        }

        nav ul ul {
            display: none;
            background: #05a489;
            position: absolute;
            top: 100%;
            box-shadow: -3px 3px 10px -2px rgba(0, 0, 0, .1);
            border: 1px solid rgba(0, 0, 0, .1);
        }

        nav ul ul li {
            float: none;
            position: relative;
        }

        nav ul ul li a {
            padding: 15px 30px;
            border-bottom: 1px solid rgba(0, 0, 0, .05);
        }

        nav ul ul ul {
            position: absolute;
            left: 100%;
            top: 0;
        }

        /* button design */

        a.button24 {
            display: inline-block;
            color: white;
            text-decoration: none;
            padding: .5em 2em;
            outline: none;
            border-width: 2px 0;
            border-style: solid none;
            border-color: #FDBE33 #000 #D77206;
            border-radius: 6px;
            background: linear-gradient(#F3AE0F, #E38916) #E38916;
            transition: 0.2s;
        }

        a.button24:hover {
            background: linear-gradient(#f5ae00, #f59500) #f5ae00;
        }

        a.button24:active {
            background: linear-gradient(#f59500, #f5ae00) #f59500;
        }

        /* task style */

        .ghost-button-semi-transparent {
            display: inline-block;
            width: 200px;
            padding: 8px;
            color: #fff;
            border: 1px solid #fff;
            border-radius: 5px;
            text-align: center;
            outline: none;
            text-decoration: none;
            transition: background-color 0.2s ease-out,
            border-color 0.2s ease-out;
        }

        .ghost-button-semi-transparent:hover,
        .ghost-button-semi-transparent:active {
            background-color: #fff; /* fallback */
            background-color: rgba(255, 255, 255, 0.4);
            border-color: #fff; /* fallback */
            border-color: rgba(255, 255, 255, 0.4);
            transition: background-color 0.3s ease-in,
            border-color 0.3s ease-in;
        }


    </style>

    <script>
        $(window).on("load resize ", function () {
            var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
            $('.tbl-header').css({'padding-right': scrollWidth});
        }).resize();
    </script>
</head>
<body>

<%--<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h1>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h1>

    </c:if>

</div>--%>

<form id="logoutForm" method="POST" action="${contextPath}/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<nav role='navigation'>
    <ul>
        <li><a href="<%--<c:url value='/addTask/${acc}'/>--%>">Создать спор</a></li>
        <%-- <li><a href="#">Filter</a>
             <ul>
                 <li><a href="">This week tasks</a></li>
                 <li><a href="">This month tasks</a></li>
             </ul>
         </li>--%>
        <li><a href="" target="_blank">Изменить профиль</a></li>
        <li><a onclick="document.forms['logoutForm'].submit()">
        </a>Выйти из ${pageContext.request.userPrincipal.name}</li>


    </ul>
</nav>


<br/>
<br/>
<br/>
<br/>
<br/>

<table>
    <tr>
        <td>
            <h2>Сыгранные матчи</h2>
            <c:if test="${!empty listOfMatches}">
                <table class="tbl-content">
                    <tr class="tbl-header">
                        <th width="120">Дата</th>
                        <th width="120">Результат</th>
                    </tr>
                    <c:forEach items="${listOfMatches}" var="match">
                        <tr>
                            <c:if test="${match.finished}">
                                <td>${match.date}</td>
                                <td><a href="" class="ghost-button-semi-transparent">
                                        ${match.left} ${match.leftRes} : ${match.rightRes} ${match.right}</a></td>
                            </c:if>

                                <%--  <td>${task.deadLineOfTask}</td>
                                  <td><a href="<c:url value='/edit/${task.numberOfTask}/${acc}'/>" class="button24"> Edit</a></td>
                                  <td><a href="<c:url value='/done/${task.numberOfTask}/${acc}'/>">
                                      <img src="http://suttonstoves.co.uk/images/Icon-check-white.png"
                                           border="0" width="25" height="25" align="middle" ></a></td>
                                  <td><a href="<c:url value='/remove/${task.numberOfTask}/${acc}'/>">
                                      <img src="http://www.iconsplace.com/icons/preview/white/delete-256.png"
                                           border="0" width="25" height="25"  ></a></td>--%>
                        </tr>

                    </c:forEach>
                </table>
            </c:if>
        </td>
        <td>
            <h2>Ближайшие матчи</h2>
            <c:if test="${!empty listOfMatches}">
                <table class="tbl-content">
                    <tr class="tbl-header">
                        <th width="120">Дата</th>
                        <th width="120">Противостояние</th>
                    </tr>
                    <c:forEach items="${listOfMatches}" var="match">
                        <tr>
                            <c:if test="${!match.finished}">
                                <td>${match.date}</td>
                                <td><a href="" class="ghost-button-semi-transparent">
                                        ${match.left} : ${match.right}</a></td>
                            </c:if>
                                <%--  <td>${task.deadLineOfTask}</td>
                                  <td><a href="<c:url value='/edit/${task.numberOfTask}/${acc}'/>" class="button24"> Edit</a></td>
                                  <td><a href="<c:url value='/done/${task.numberOfTask}/${acc}'/>">
                                      <img src="http://suttonstoves.co.uk/images/Icon-check-white.png"
                                           border="0" width="25" height="25" align="middle" ></a></td>
                                  <td><a href="<c:url value='/remove/${task.numberOfTask}/${acc}'/>">
                                      <img src="http://www.iconsplace.com/icons/preview/white/delete-256.png"
                                           border="0" width="25" height="25"  ></a></td>--%>
                        </tr>

                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>


</body>
</html>