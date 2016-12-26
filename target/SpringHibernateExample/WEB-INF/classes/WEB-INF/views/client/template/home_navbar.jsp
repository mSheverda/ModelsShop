<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--header-->
<div class="header">
    <div class="header-top">
        <div class="container">

            <div class="header-left">

                <form class="form-inline" role="form" action="/SpringMVC_war_exploded/search" method="post">
                    <input type="text" class="form-control" name="pattern" placeholder="Название товара">
                    <input type="submit" class="btn btn-success" value="Поиск">

                    <div class="cart box_1">
                        <a href="checkout.html">
                            <h3>

                                <img src="../../../resources/images/cart.png" alt=""/>
                                <c:if test="${cart_size > 0}">
                                    (${cart_size})
                                </c:if>


                            </h3>
                        </a>
                        <br/>
                    </div>

                </form>
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
                    <li><a class="color4" href="home#categories">Категории</a></li>
                    <li><a class="color4" href="home#products">Товары</a></li>
                    <li><a class="color4" href="contacts">Контакты</a></li>

                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>
</div>
