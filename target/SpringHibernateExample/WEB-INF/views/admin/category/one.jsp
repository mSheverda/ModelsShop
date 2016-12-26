<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <title>Категория ${category.title}|| Models Shop</title>
        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>КАТЕГОРИЯ "${category.title}"</h2>
        </div>
    </div>

    <!-- Category -->
    <div class="container">
            <div class="row admin-page">
               <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <table class="table">
                        <tr>
                            <th>Название:</th>
                            <td>${category.title}</td>
                        </tr>
                        <tr>
                            <th>URl:</th>
                            <td>
                                <a href="../category_${category.url}"
                                   title="Перейти к категории ${category.title}">
                                        ${category.url}</a>
                            </td>
                        </tr>
                        <tr>
                            <th>Описание:</th>
                            <td>${category.description}</td>
                        </tr>
                        <tr>
                            <th>Изображение:</th>
                            <td>${category.photo.title}
                                <br><img width="500px" height="250px"
                                         src="/resources/img/category/${category.photo.photoLinkShort}">


                            </td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <a href="edit_category_${category.id}"
                                   title="Редактировать категорию ${category.title}">
                                    <button class="btn btn-success" type="submit">Редактировать</button>
                                </a>
                                <a href="delete_category_${category.id}"
                                   title="Удалить категорию ${category.title}">
                                    <button class="btn btn-danger" type="submit">Удалить</button>
                                </a>
                                <a href="categories" title="Вернуться к списку категорий">
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
