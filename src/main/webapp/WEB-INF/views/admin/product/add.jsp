<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
        <title>Товары || Models Shop</title>

        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>ДОБАВИТЬ ТОВАР</h2>

        </div>
    </div>

    <!-- Add product -->
    <div class="container">

            <div class="row admin-page">
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

    </div>
    </body>
    </html>
</compress:html>
