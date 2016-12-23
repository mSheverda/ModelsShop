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

        <meta name="title" content="Заказ ${order.number} || Models Shop">
        <title>Заказ ${order.number} || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- Order -->
    <div class="container-fluid width">
        <section id="order">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>
                            <span class="color-brown">Заказ </span>
                            <span class="color-green">${order.number}</span>
                        </b>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <table class="table">
                        <tr>
                            <th>Номер:</th>
                            <td>${order.number}</td>
                        </tr>
                        <tr>
                            <th>Статус:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${order.status eq status_new}">
                                        <span class="color-green"><b>${order.status.description}</b></span>
                                    </c:when>
                                    <c:otherwise>
                                        ${order.status.description}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Дата:</th>
                            <td>${order.date}</td>
                        </tr>
                        <tr>
                            <th>Заказ обработал:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${order.manager ne null}">
                                        <c:choose>
                                            <c:when test="${order.manager.role eq admin_role}">
                                                <span class="color-red">${order.manager.role.description}</span>
                                            </c:when>
                                            <c:when test="${order.manager.role eq manager_role}">
                                                <span class="color-green">${order.manager.role.description}</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${order.manager.role.description}
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="view_user_${order.manager.id}">${order.manager.name}</a>
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Клиент:</th>
                            <td>
                                Имя: <b>${order.client.name}</b>
                                <br>Email: <b>${order.client.email}</b>
                                <br>Телефон: <b>${order.client.phone}</b>
                            </td>
                        </tr>
                        <tr>
                            <th>Адрес доставки:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${(order.shippingAddress ne null) and (order.shippingAddress ne '')}">
                                        ${order.shippingAddress}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Детали доставки:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${(order.shippingDetails ne null) and (order.shippingDetails ne '')}">
                                        ${order.shippingDetails}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Коментарии:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${(order.description ne null) and (order.description ne '')}">
                                        ${order.description}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Товары:</th>
                            <td>
                                <c:choose>
                                    <c:when test="${fn:length(sale_positions) gt 0}">
                                        <c:forEach items="${sale_positions}" var="position">
                                            <a href="../product_${position.product.url}"
                                               title="Перейти к товару ${position.product.title}">
                                                    ${position.product.title}</a>, № ${position.product.id},
                                            <br>${position.number} x ${position.product.price} грн
                                            <br>--------------<br>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        Cписок товаров пуст!
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>Общая сумма:</th>
                            <td><b>${order_price}</b> грн</td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <a href="edit_order_${order.id}" title="Редактировать заказ ${order.number}">
                                    <button class="btn btn-success" type="submit">Редактировать</button>
                                </a>
                                <a href="delete_order_${order.id}" title="Удалить заказ ${order.number}">
                                    <button class="btn btn-danger" type="submit">Удалить</button>
                                </a>
                                <a href="orders" title="Вернуться к списку заказов">
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
