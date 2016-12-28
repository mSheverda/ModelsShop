<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <title>${product.title}</title>

        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>${product.title}</h2>

        </div>
    </div>

    <!-- Product -->
    <div class="container">

            <div class="row admin-page">

                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <table class="table">
                        <tr>
                            <th>Название:</th>
                            <td>
                                <a href="../product_${product.url}"
                                   title="Перейти к товару ${product.title}">
                                        ${product.title}
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <th>Категория:</th>
                            <td>
                                <a href="view_category_${product.id}"
                                   title="Смотреть категорию ${product.category.title}">
                                        ${product.category.title}</a>
                            </td>
                        </tr>
                        <tr>
                            <th>Производитель:</th>
                            <td>${product.manufacturer}</td>
                        </tr>
                        <tr>
                            <th>Сложность:</th>
                            <td>${product.difficulty}</td>
                        </tr>
                        <tr>
                            <th>Масштаб:</th>
                            <td>${product.scale}</td>
                        </tr>
                        <tr>
                            <th>Количество деталей:</th>
                            <td>${product.details}</td>
                        </tr>
                        <tr>
                            <th>Описание:</th>
                            <td>${product.description}</td>
                        </tr>
                        <tr>
                            <th>Изображение:</th>
                            <td>
                                ${product.photo.title}
                                <br><img width="210px"
                                         src="../../../resources/images/product/${product.photo.photoLinkShort}">
                                <c:if test="${product.photo.photoLinkLong ne null}">
                                    <img width="391px"
                                         src="../../../resources/images/product/${product.photo.photoLinkLong}">
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>Цена:</th>
                            <td>${product.price}</td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <a href="edit_product_${product.id}"
                                   title="Редактировать товар ${product.title}">
                                    <button class="btn btn-success" type="submit">Редактировать</button>
                                </a>
                                <a href="delete_product_${product.id}"
                                   title="Удалить товар ${product.title}">
                                    <button class="btn btn-danger" type="submit">Удалить</button>
                                </a>
                                <a href="products" title="Вернуться к списку товаров">
                                    <button class="btn btn-info" type="submit">Назад</button>
                                </a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>

    </div>
    </body>
    </html>
</compress:html>
