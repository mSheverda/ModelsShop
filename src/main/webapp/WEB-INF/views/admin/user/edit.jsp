<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <!-- HEAD -->
        <!-- HEAD -->
        <meta charset="utf-8">
        <meta lang="ru">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="robots" content="noindex,nofollow">
        <!-- Favicon -->
        <link rel="shortcut icon" href="../resources/img/favicon.ico" type="image/x-icon">
        <link rel="icon" href="../resources/img/favicon.ico" type="image/x-icon">
        <!-- Styles -->
        <link href="../resources/css.min.css" rel="stylesheet" type="text/css">
        <link href="../resources/css/animate.css" rel="stylesheet" type="text/css">
        <link href="../resources/css/style.css" rel="stylesheet" type="text/css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"
              type="text/css">
        <!-- Scripts -->
        <script src="../resources/js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../resources/js/jquery.appear.js" type="text/javascript"></script>
        <script src="../resources/js.min.js" type="text/javascript"></script>
        <script src="../resources/js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
        <meta name="title" content="${user.name} || Models Shop">
        <title>${user.name} || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- Edit user -->
    <div class="container-fluid width">
        <section id="user" class="admin">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b><span class="color-green">${user.name}</span></b>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <form action="update_user" method="post">
                        <input type="hidden" name="id" value="${user.id}">
                        <table class="table">
                            <tr>
                                <th>Имя:</th>
                                <td>
                                    <input class="input-order" type="text" name="name"
                                           placeholder=" Введите имя" value="${user.name}"
                                           minlength="2" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>Роль:</th>
                                <td>
                                    <select class="input-order" name="role">
                                        <option value="${user.role.id}">${user.role.description}</option>
                                        <c:forEach items="${roles}" var="role">
                                            <c:if test="${role ne user.role}">
                                                <option value="${role.id}">${role.description}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Логин:</th>
                                <td>
                                    <input class="input-order" type="text" name="username" pattern="[A-Za-z0-9_]{5,50}"
                                           placeholder=" Введите логин, формат (A-Z, a-z, 0-9, _)"
                                           value="${user.username}"
                                           minlength="5" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>Пароль:</th>
                                <td>
                                    <input class="input-order" type="text" name="password" pattern="[A-Za-z0-9]{6,50}"
                                           placeholder=" Введите пароль, формат (A-Z, a-z, 0-9)"
                                           value="${user.password}"
                                           minlength="6" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>Email:</th>
                                <td>
                                    <input class="input-order" type="email" name="email" pattern="[A-Za-z0-9_.@]{5,50}"
                                           placeholder=" Введите электронную почту, формат (A-Z, a-z, 0-9, _, ., @)"
                                           value="${user.email}" minlength="5" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>Телефон:</th>
                                <td>
                                    <input class="phone input-order" type="text" name="phone"
                                           placeholder=" Введите телефон" value="${user.phone}" required>
                                </td>
                            </tr>
                            <tr>
                                <th>ВКонтакте:</th>
                                <td>
                                    <input class="input-order" type="text" name="vkontakte" pattern="[a-z0-9_/.]{5,50}"
                                           placeholder=" Введите адрес ВКонтакте, формат (a-z, 0-9, _, /, .)"
                                           value="${user.vkontakte}" minlength="5" maxlength="50">
                                </td>
                            </tr>
                            <tr>
                                <th>Facebook:</th>
                                <td>
                                    <input class="input-order" type="text" name="facebook" pattern="[a-z0-9_/.]{5,50}"
                                           placeholder=" Введите адрес Facebook, формат (a-z, 0-9, _, /, .)"
                                           value="${user.facebook}" minlength="5" maxlength="50">
                                </td>
                            </tr>
                            <tr>
                                <th>Skype:</th>
                                <td>
                                    <input class="input-order" type="text" name="skype" pattern="[A-Za-z0-9_.]{5,50}"
                                           placeholder=" Введите логин Skype, формат (A-Z, a-z, 0-9, _, .)"
                                           value="${user.skype}" minlength="5" maxlength="50">
                                </td>
                            </tr>
                            <tr>
                                <th>Описание:</th>
                                <td>
                                <textarea class="input-order textarea" name="description"
                                          placeholder=" Введите описание работника"
                                          maxlength="250">${user.description}</textarea>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button class="btn btn-success" type="submit"
                                            title="Обновить информацию о пользователи">Сохранить
                                    </button>
                                    <button class="btn btn-info" type="reset" title="Сбросить введенные даные">Сброс
                                    </button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </section>
    </div>
    </body>
    </html>
</compress:html>
