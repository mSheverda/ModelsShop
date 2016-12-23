<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<html>

<head>


    <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
</head>

<body>
<div class="width">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span><span class="icon-bar"></span>
                </button>
                <div class="navbar-brand text-shadow">
                    <a href="../home">
                        <span class="nav-text-label color-green">Models</span>
                        <span class="nav-text-label color-brown">Shop</span>
                    </a>
                    <a href="../admin">
                        <span class="nav-text-label color-red">A</span>
                    </a>
                </div>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <div id="menu-product">
                    <ul class="nav navbar-nav">
                        <li id="nav-orders"><a href="/admin/orders">Заказы</a></li>
                        <li id="nav-main"><a href="/admin/products">Товары</a></li>
                        <li id="nav-categories"><a href="/admin/categories">Категории</a></li>
                        <li id="nav-persons"><a href="/admin/users">Персонал</a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li id="auth-user"><a href="view_user_${auth_user.id}">${auth_user.name}</a></li>
                        <li id="nav-logout">
                            <form class="form-signin" action="../logout" method="post">
                                <input type="hidden" id="username" name="username">
                                <button class="btn-logout btn btn-danger" type="submit">Выйти</button>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
</body>
</html>