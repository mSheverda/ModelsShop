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

        <meta name="title" content="Новый продукт || Models Shop">
        <title>Новый продукт || Models Shop</title>
    </head>
    <body>

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/views/admin/admin_navbar.jsp"/>

    <!-- Add product -->
    <div class="container-fluid width">
        <section id="product" class="admin">
            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">
                        <b>
                            <span class="color-green">Новый </span>
                            <span class="color-brown">товар</span>
                        </b>
                    </div>
                </div>

                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                    <form enctype="multipart/form-data" action="save_product" method="post">
                        <table class="table">
                            <tr>
                                <th>Название:</th>
                                <td>
                                    <input class="input-order" type="text" name="title"
                                           placeholder="Введите название товара"
                                           minlength="5" maxlength="100" required>
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
                                <th>Категория:</th>
                                <td>
                                    <select class="input-order" name="category">
                                        <c:forEach items="${categories}" var="category">
                                            <option value="${category.id}">${category.title}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <th>Производитель:</th>
                                <td>
                                <input class="input-order" type="text" name="manufacturer"
                                          placeholder="Введите название производителя" maxlength="100" required/>
                                </td>
                            </tr>
                            <tr>
                                <th>Сложность:</th>
                                <td>
                                <input class="input-order" type="text" name="difficulty"
                                          placeholder="Введите уровень сложности" maxlength="50" required/>
                                </td>
                            </tr>
                            <tr>
                                <th>Масштаб:</th>
                                <td>
                                <input class="input-order" type="text" name="scale"
                                          placeholder="Введите масштаб" maxlength="50" required/>
                                </td>
                            </tr>
                            <tr>
                                <th>Количество деталей:</th>
                                <td>
                                <input class="input-order" type="text" name="details" pattern="[0-9]{1,6}"
                                          placeholder="Введите количество деталей" maxlength="6" required/>
                                </td>
                            </tr>
                            <tr>
                                <th>Описание:</th>
                                <td>
                                <textarea class="input-order textarea" name="description"
                                          placeholder="Введите описание товара" maxlength="500"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th>Изображение:</th>
                                <td>
                                    <input class="input-order" type="text" name="photo_title"
                                           placeholder="Введите название фото"
                                           minlength="5" maxlength="100" required>
                                    <br>Малое: <input type="file" name="small_photo" accept="image/*">
                                    <br>Большое: <input type="file" name="big_photo" accept="image/*">
                                </td>
                            </tr>
                            <tr>
                                <th>Цена:</th>
                                <td>
                                    <input class="input-order" type="number" name="price"
                                           placeholder="Введите цену товара"
                                           min="0" max="99999" step="0.01" required>
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <button class="btn btn-success" type="submit">Добавить товар</button>
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
