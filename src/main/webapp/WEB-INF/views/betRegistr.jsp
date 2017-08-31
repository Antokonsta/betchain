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
<body >
<div class="body">

    <form action="" class="sky-form">
        <header>Регистрация спора</header>
        <header> <img src="${matchLeftPic}" border="0" width="50" height="50">
            ${matchLeft} : ${matchRight}
            <img src="${matchRightPic}" border="0" width="50" height="50"></header>

        <fieldset>
            <div class="row">
                <section class="col col-6">
                    <label class="textarea">
                        <textarea readonly rows="2" placeholder="User">${pageContext.request.userPrincipal.name}</textarea>
                    </label>
                </section>
                <section class="col col-6">
                    <label class="textarea">
                        <textarea readonly rows="2" placeholder="Date">18.05.2017</textarea>
                    </label>
                </section>
            </div>

        </fieldset>

        <fieldset>
            <div class="row">
                <section class="col col-5">
                    <label class="select">
                        <select>
                            <option value="0" selected disabled>Country</option>
                            <option value="244">Aaland Islands</option>
                            <option value="1">Afghanistan</option>
                            <option value="2">Albania</option>
                            <option value="3">Algeria</option>

                            <select>
                                <i></i>
                    </label>
                </section>

                <section class="col col-4">
                    <label class="input">
                        <input type="tel" placeholder="City">
                    </label>
                </section>

                <section class="col col-3">
                    <label class="input">
                        <input type="tel" placeholder="Post code">
                    </label>
                </section>
            </div>

            <section>
                <label for="file" class="input">
                    <input type="tel" placeholder="Address">
                </label>
            </section>

            <section>
                <label class="textarea">
                    <textarea rows="3" placeholder="Additional info"></textarea>
                </label>
            </section>
        </fieldset>

        <fieldset>
            <section>
                <div class="inline-group">
                    <label class="radio"><input type="radio" name="radio-inline" checked><i></i>Visa</label>
                    <label class="radio"><input type="radio" name="radio-inline"><i></i>MasterCard</label>
                    <label class="radio"><input type="radio" name="radio-inline"><i></i>PayPal</label>
                </div>
            </section>

            <section>
                <label class="input">
                    <input type="text" placeholder="Name on card">
                </label>
            </section>

            <div class="row">
                <section class="col col-10">
                    <label class="input">
                        <input type="text" placeholder="Card numberd">
                    </label>
                </section>
                <section class="col col-2">
                    <label class="input">
                        <input type="text" maxlength="3" placeholder="CVV2">
                    </label>
                </section>
            </div>

            <div class="row">
                <label class="label col col-4">Expiration date</label>
                <section class="col col-5">
                    <label class="select">
                        <select>
                            <option value="0" selected disabled>Month</option>
                            <option value="1">January</option>
                            <option value="1">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <i></i>
                    </label>
                </section>
                <section class="col col-3">
                    <label class="input">
                        <input type="text" maxlength="4" placeholder="Year">
                    </label>
                </section>
            </div>
        </fieldset>

        <footer>
            <button type="submit" class="button">Continue</button>
        </footer>
    </form>

</div>
</body>
</html>