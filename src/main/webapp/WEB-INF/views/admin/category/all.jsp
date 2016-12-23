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
        <link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="../resources/bootstrap/css/animate.css" rel="stylesheet" type="text/css">
        <link href="../resources/bootstrap/css/style.css" rel="stylesheet" type="text/css">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"
              type="text/css">
        <!-- Scripts -->
        <script src="../resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="../resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
        <script src="../resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../resources/bootstrap/js/jquery.maskedinput.min.js" type="text/javascript"></script>

        <meta name="title" content="Категории моделей || Models Shop">
        <title>Категории моделей || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- All categories -->
    <div class="container-fluid width">
        <section id="categories" class="admin">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>
                            <span class="color-brown">Категории</span>
                            <c:if test="${fn:length(categories) eq 0}">
                                <span class="color-red"> - список пуст!</span>
                                <br>
                                <a href="add_category" title="Добавить новую категорию">
                                    <button class="btn btn-success" type="submit">Добавить</button>
                                </a>
                            </c:if>
                        </b>
                    </div>
                </div>

                <c:if test="${fn:length(categories) gt 0}">
                    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                        <table class="table">
                            <tr>
                                <th>Название</th>
                                <td class="hidden-xs"><b>URL</b></td>
                                <th>
                                    Действие
                                    <a href="add_category" title="Добавить новую категорию">
                                        <button class="btn btn-success" type="submit">Добавить</button>
                                    </a>
                                    <a href="delete_all_categories" title="Удалить все категории">
                                        <button class="btn btn-danger" type="submit">Удалить ВСЕ</button>
                                    </a>
                                </th>
                            </tr>

                            <c:forEach items="${categories}" var="category">
                                <tr>
                                    <td>
                                        <a href="../category_${category.url}"
                                           title="Перейти к категории ${category.title}">
                                                ${category.title}</a>
                                    </td>
                                    <td class="hidden-xs">${category.url}</td>
                                    <td>
                                        <a href="view_category_${category.id}"
                                           title="Смотреть категорию ${category.title}">
                                            <button class="btn btn-info" type="submit">Смотреть</button>
                                        </a>
                                        <a href="edit_category_${category.id}"
                                           title="Редактировать категорию ${category.title}">
                                            <button class="btn btn-success" type="submit">Редактировать</button>
                                        </a>
                                        <a href="delete_category_${category.id}"
                                           title="Удалить категорию ${category.title}">
                                            <button class="btn btn-danger" type="submit">Удалить</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>
        </section>
    </div>
    </body>
    </html>
</compress:html>
