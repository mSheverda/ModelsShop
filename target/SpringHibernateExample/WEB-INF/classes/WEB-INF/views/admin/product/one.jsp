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

        <meta name="title" content="${product.title} || Models Shop">
        <title>${product.title} || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- Product -->
    <div class="container-fluid width">
        <section id="product" class="admin">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>
                            <span class="color-brown">Товар </span>
                            <span class="color-green">"${product.title}"</span>
                        </b>
                    </div>
                </div>

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
                                <br><img width="210px" height="200px"
                                         src="/resources/img/product/${product.photo.photoLinkShort}">
                                <c:if test="${product.photo.photoLinkLong ne null}">
                                    <img width="391px" height="300px"
                                         src="/resources/img/product/${product.photo.photoLinkLong}">
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
        </section>
    </div>
    </body>
    </html>
</compress:html>
