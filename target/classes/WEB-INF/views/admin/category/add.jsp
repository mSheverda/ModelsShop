<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>

    <html>
    <head>
        <title>Новая категория || Models Shop</title>
        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>НОВАЯ КАТЕГОРИЯ</h2>
        </div>
    </div>

    <!-- Add category -->
    <div class="container">
           <div class="row admin-page">
               <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <form enctype="multipart/form-data" action="save_category" method="post">
                        <table class="table">
                            <tr>
                                <th>Название:</th>
                                <td>
                                    <input class="input-order" type="text" name="title"
                                           placeholder=" Введите название категории"
                                           minlength="5" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>URL:</th>
                                <td>
                                    <input class="input-order" type="text" name="url" pattern="[a-z0-9_]{5,50}"
                                           placeholder=" Введите URL, формат (a-z, 0-9, _)"
                                           minlength="5" maxlength="50" required>
                                </td>
                            </tr>
                            <tr>
                                <th>Описание:</th>
                                <td>
                                <textarea class="input-order textarea" name="description"
                                          placeholder=" Введите описание категории" maxlength="500"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>Изображение:</th>
                                <td>
                                    <input class="input-order" type="text" name="photo_title"
                                           placeholder="Введите название фото" minlength="5" maxlength="100" required>
                                    <br><input type="file" name="photo" accept="image/*">
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button class="btn btn-success" type="submit">Добавить категорию</button>
                                    <button class="btn btn-info" type="reset">Сброс</button>
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
