<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Регистрация спора</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

    <link rel="stylesheet" href="../../resources/css/demo.css">
    <link rel="stylesheet" href="../../resources/css/sky-forms.css">
    <link rel="stylesheet" href="../../resources/css/sky-forms-purple.css">

    <style type="text/css">
        @import url(http://fonts.googleapis.com/css?family=Roboto:400,500,300,700);

        body {
            background: -webkit-linear-gradient(left, #25c481, #25b7c4);
            background: linear-gradient(to right, #25c481, #25b7c4);
            font-family: 'Roboto', sans-serif;
        }
    </style>

    <![endif]-->

    <!--[if lt IE 10]>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="js/jquery.placeholder.min.js"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <script src="js/sky-forms-ie8.js"></script>
    <![endif]-->
</head>
<body>
<div class="body">

    <form action="" class="sky-form">
        <header>Регистрация спора</header>
        <header><img src="${matchLeftPic}" border="0" width="50" height="50">
            ${matchLeft} : ${matchRight}
            <img src="${matchRightPic}" border="0" width="50" height="50"></header>
        <fieldset>
            <div class="row">
                <section class="col col-6">
                    <label class="textarea">
                        <i class="icon-prepend"> <img src='../../resources/img/images.png' border="0" width="20"
                                                      height="20"></i>
                        <textarea readonly rows="1"
                                  placeholder="User">${pageContext.request.userPrincipal.name}</textarea>
                    </label>
                </section>
                <section class="col col-6">
                    <label class="textarea">
                        <i class="icon-prepend"> <img src='../../resources/img/calendrier.png' border="0" width="20"
                                                      height="20"></i>
                        <textarea readonly rows="1" placeholder="Date">18.05.2017</textarea>
                    </label>
                </section>
            </div>

        </fieldset>

        <fieldset>
            <div class="row">
                <section class="col col-6">
                    <label class="label">Ставки на игру</label>
                    <label class="toggle"><input type="checkbox" name="checkbox-toggle" checked><i></i>Тестовая
                        валюта</label>
                </section>
            </div>
            <div class="row">
                <section class="col col-6">
                    <label class="input">
                        <i class="icon-prepend"> <img src='../../resources/img/money.png' border="0" width="20"
                                                      height="20"></i>
                        <input type="text" placeholder="Ставка">
                    </label>
                </section>
                <section class="col col-6">
                    <label class="select">
                        <select>
                            <option value="0" selected disabled>Ставка на</option>
                            <option value="1">Хозяева</option>
                            <option value="2">Гости</option>
                            <select>
                                <i></i>
                    </label>
                </section>
            </div>
        </fieldset>
        <fieldset>
            <div class="row">
                <section class="col col-6">
                    <label class="toggle"><input type="checkbox" name="checkbox-toggle" checked><i></i>Приватный спор</label>
                </section>
                <section class="col col-6">
                    <label class="select">
                        <select>
                            <option value="0" selected disabled>Выберите друга</option>
                            <option value="1">Леха</option>
                            <option value="2">Тоха</option>
                            <select>
                                <i></i>
                    </label>
                </section>
            </div>
        </fieldset>



        <footer>
            <button type="submit" class="button">Создать</button>
            <button type="button" class="button button-secondary" onclick="window.history.back();">Назад</button>
        </footer>
    </form>

</div>
</body>
</html>