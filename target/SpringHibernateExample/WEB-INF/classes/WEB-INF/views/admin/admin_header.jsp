<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<html>

<head>
    <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
</head>

<body>
<div class="header">
    <div class="header-top">
        <div class="container">
            <div class="header-left">
            <div class="header-left">
            <form class="form-inline" role="form" action="../logout" method="post">
                        <a href="view_user_${auth_user.id}">${auth_user.name}</a>
                        <input type="hidden" id="username" name="username">
                        &nbsp;
                            <button class="btn-logout btn btn-danger" type="submit">Выйти</button>
                    </form>
            </div>
                <div class="clearfix"> </div>
            </div>

        </div>
    </div>


    <div class="container">
        <div class="head-top">
            <div class="logo">
                <h1><a href="home">Models Shop</a></h1>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li><a class="color4" href="/admin/orders">Заказы</a></li>
                    <li><a class="color4" href="/admin/products">Товары</a></li>
                    <li><a class="color4" href="/admin/categories">Категории</a></li>
                    <li><a class="color4" href="/admin/users">Клиенты</a></li>

                </ul>

            </div>
            <div class="clearfix"> </div>

        </div>
    </div>
</div>


</body>
</html>