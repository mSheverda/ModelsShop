<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>

    <head>
        <title>Заказы || Models Shop</title>

        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>ЗАКАЗЫ</h2>

        </div>
    </div>

    <!-- All orders -->
    <div class="container-fluid width">

            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>

                            <c:if test="${fn:length(orders) eq 0}">
                                <span class="color-red"> - список пуст!</span>
                            </c:if>
                        </b>
                    </div>
                </div>

                <c:if test="${fn:length(orders) gt 0}">
                    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                        <table class="table">
                            <tr>
                                <th>Номер</th>
                                <th>Статус</th>
                                <th class="hidden-xs">Дата</th>
                                <th>
                                    Действие
                                    <a href="delete_all_orders" title="Удалить все заказы">
                                        <button class="btn btn-danger" type="submit">Удалить ВСЕ</button>
                                    </a>
                                </th>
                            </tr>
                            <c:forEach items="${orders}" var="order">
                                <tr>
                                    <td>${order.number}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${order.status eq status_new}">
                                                <span class="color-green">${order.status.description}</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${order.status.description}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="hidden-xs">${order.date}</td>
                                    <td>
                                        <a href="view_order_${order.id}" title="Смотреть заказ ${order.number}">
                                            <button class="btn btn-info" type="submit">Смотреть</button>
                                        </a>
                                        <a href="edit_order_${order.id}"
                                           title="Редактировать заказ ${order.number}">
                                            <button class="btn btn-success" type="submit">Редактировать</button>
                                        </a>
                                        <a href="delete_order_${order.id}" title="Удалить заказ ${order.number}">
                                            <button class="btn btn-danger" type="submit">Удалить</button>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if>
            </div>

    </div>
    </body>
    </html>
</compress:html>
