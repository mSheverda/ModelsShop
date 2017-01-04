<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
          <title>Клиенты</title>

        <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    </head>
    <body>
    <jsp:include page="/WEB-INF/views/admin/admin_header.jsp"/>

    <div class="grow">
        <div class="container">
            <h2>КЛИЕНТЫ</h2>

        </div>
    </div>

    <!-- All users -->
    <div class="container">

            <div class="row admin-page">
                <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
                    <div class="row section-name text-shadow">

                        <div class="clearfix"></div>
                        <b>

                            <c:if test="${fn:length(users) eq 0}">
                                <span class="color-red"> - список пуст!</span>
                                <br>
                                <a href="add_user" title="Добавить нового работника">
                                    <button class="btn btn-success" type="submit">Добавить</button>
                                </a>
                            </c:if>
                        </b>
                    </div>
                </div>

                <c:if test="${fn:length(users) gt 0}">
                    <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
                        <div class="clearfix"></div>
                        <table class="table table-striped">
                            <tr class="table-success">
                                <th>Роль</th>
                                <th>Имя</th>
                                <td class="hidden-xs"><b>Телефон</b>
                                <td>
                                    <b>Действие</b>
                                &nbsp;&nbsp;
                                    <a href="add_user" title="Добавить нового пользователя">
                                        <button class="btn btn-success" type="submit">Добавить</button>
                                    </a>
                                &nbsp;&nbsp;
                                <a href="delete_all_users" title="Удалить всех пользователей">
                                        <button class="btn btn-danger" type="submit">Удалить всех</button>
                                    </a>
                                </td>
                            </tr>

                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.role eq admin_role}">
                                                <b><span class="color-red">${user.role.description}</span></b>
                                            </c:when>
                                            <c:when test="${user.role eq manager_role}">
                                                <span class="color-green">${user.role.description}</span>
                                            </c:when>
                                            <c:otherwise>
                                                ${user.role.description}
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${user.name}</td>
                                    <td class="hidden-xs">${user.phone}</td>
                                    <td>
                                        <a href="view_user_${user.id}"
                                           title="Смотреть информацию ${user.name}">
                                            <button class="btn btn-info btn-mg" type="submit">Смотреть</button>
                                        </a>
                                        <a href="edit_user_${user.id}"
                                           title="Редактировать информацию о менеджере ${user.name}">
                                            <button class="btn btn-success btn-mg" type="submit">Редактировать</button>
                                        </a>
                                        <a href="delete_user_${user.id}"
                                           title="Удалить информацию о ${user.name}">
                                           <button class="btn btn-danger btn-mg" type="submit">Удалить</button>
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
