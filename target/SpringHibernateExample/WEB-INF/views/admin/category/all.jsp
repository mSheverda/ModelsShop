<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <title>Категории</title>
        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>КАТЕГОРИИ</h2>
        </div>
    </div>

    <!-- All categories -->
    <div class="container">

            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>

                            <c:if test="${fn:length(categories) eq 0}">
                                <h2>Cписок пуст!</h2>
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
                        <table class="table table-striped">
                            <tr>
                                <th>Название</th>
                                <td class="hidden-xs"><b>URL</b></td>
                                <th>

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
    </div>
    </body>
    </html>
</compress:html>
