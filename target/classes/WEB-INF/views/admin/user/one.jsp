<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
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
        <meta name="title" content="${user.name} | ${user.role.description} || Models Shop">
        <title>${user.name} | ${user.role.description} || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- User -->
    <div class="container-fluid width">
        <section id="product" class="admin">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>
                            <span class="color-brown">${user.name}</span>
                        </b>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <table class="table">
                        <tr>
                            <th>Имя:</th>
                            <td>${user.name}</td>
                        </tr>
                        <tr>
                            <th>Роль:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${user.role eq admin_role}">
                                        <span class="color-red">${user.role.description}</span>
                                    </c:when>
                                    <c:when test="${user.role eq manager_role}">
                                        <span class="color-green">${user.role.description}</span>
                                    </c:when>
                                    <c:otherwise>
                                        ${user.role.description}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Логин:</th>
                            <td>${user.username}</td>
                        </tr>
                        <tr>
                            <th>Пароль:</th>
                            <td>${user.password}</td>
                        </tr>
                        <tr>
                            <th>Email:</th>
                            <td>
                                <a href="mailto:${user.email}" title="Email" target="_blank">${user.email}</a>
                            </td>
                        </tr>
                        <tr>
                            <th>Телефон:</th>
                            <td>${user.phone}</td>
                        </tr>
                        <c:if test="${(user.vkontakte ne null) and (user.vkontakte ne '')}">
                            <tr>
                                <th>ВКонтакте:</th>
                                <td>
                                    <a href="https://${user.vkontakte}" title="ВКонтакте"
                                       target="_blank">${user.vkontakte}</a>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${(user.facebook ne null) and (user.facebook ne '')}">
                            <tr>
                                <th>Facebook:</th>
                                <td>
                                    <a href="https://${user.facebook}" title="Facebook"
                                       target="_blank">${user.facebook}</a>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${(user.skype ne null) and (user.skype ne '')}">
                            <tr>
                                <th>Skype:</th>
                                <td>
                                    <a href="skype:${user.skype}?call" title="Skype" target="_blank">${user.skype}</a>
                                </td>
                            </tr>
                        </c:if>
                        <c:if test="${(user.description ne null) and (user.description ne '')}">
                            <tr>
                                <th>Описание:</th>
                                <td>${user.description}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <th></th>
                            <td>
                                <a href="edit_user_${user.id}"
                                   title="Редактировать информацию о ${user.username}">
                                    <button class="btn btn-success" type="submit">Редактировать</button>
                                </a>
                                <a href="delete_user_${user.id}"
                                   title="Удалить информацию о ${user.username}">
                                    <button class="btn btn-danger btn-mg" type="submit">Удалить</button>
                                </a>
                                <a href="users" title="Вернуться к списку пользователей">
                                    <button class="btn btn-info" type="submit">Назад</button>
                                </a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </section>
    </div>
    </body>
    </html>
</compress:html>
