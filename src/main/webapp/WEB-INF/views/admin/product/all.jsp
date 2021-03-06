<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <title>Товары</title>

        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>ТОВАРЫ</h2>

        </div>
    </div>

    <!-- All products -->
    <div class="container">

            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <div class="clearfix"></div>
                        <b>

                            <c:if test="${fn:length(products) eq 0}">
                                <br/><br/>
                                <h2>Cписок пуст!</h2>
                                <br>

                                <a href="add_product" title="Добавить новый товар">
                                    <button class="btn btn-success" type="submit">Добавить</button>
                                </a>
                            </c:if>
                        </br>
                    </div>
                </div>

                <c:if test="${fn:length(products) gt 0}">
                    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                        <div class="clearfix"></div>
                        <table class="table table-striped">
                            <tr>
                                <th width="40%">Название</th>
                                <th class="hidden-xs" width="15%">Категория</th>
                                <th width="35%">

                                    <a href="add_product" title="Добавить новый товар">
                                        <button class="btn btn-success" type="submit">Добавить</button>
                                    </a>

                                    <a href="delete_all_products" title="Удалить все товары">
                                        <button class="btn btn-danger" type="submit">Удалить ВСЕ</button>
                                    </a>
                                </th>
                            </tr>

                            <c:forEach items="${products}" var="product">
                                <tr>
                                    <td>
                                        <a href="view_product_${product.url}"
                                           title="Перейти к товару ${product.title}">
                                                ${product.title}</a>
                                    </td>
                                    <td class="hidden-xs">
                                        <a href="view_category_${product.category.id}"
                                           title="Смотреть категорию ${product.category.title}">
                                                ${product.category.title}</a>
                                    </td>
                                    <td>
                                        <a href="view_product_${product.id}"
                                           title="Смотреть товар ${product.title}">
                                            <button class="btn btn-info" type="submit">Смотреть</button>
                                        </a>
                                        <a href="edit_product_${product.id}"
                                           title="Редактировать товар ${product.title}">
                                            <button class="btn btn-success" type="submit">Редактировать</button>
                                        </a>
                                        <a href="delete_product_${product.id}"
                                           title="Удалить товар ${product.title}">
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
