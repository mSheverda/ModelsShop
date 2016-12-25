<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<html>
<head>
  <title>${category.title} || Models Shop</title>
  <link href="../../../resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="../../../resources/js/jquery.min.js"></script>
  <!-- Custom Theme files -->
  <!--theme-style-->
  <link href="../../../resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
  <!--//theme-style-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <!--fonts-->
  <link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
  <link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
  <!-- start menu -->
  <link href="../../../resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
  <script type="text/javascript" src="../../../resources/js/memenu.js"></script>
  <script>$(document).ready(function(){$(".memenu").memenu();});</script>
  <script src="../../../resources/js/simpleCart.min.js"> </script>

</head>
<body>
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
                (${cart_size})
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
        <h1><a href="index.html">Models Shop</a></h1>
      </div>
      <div class=" h_menu4">
        <ul class="memenu skyblue">
          <li><a class="color4" href="login.html">Login</a></li>
          <li><a class="color4" href="login.html">Login</a></li>
          <li><a class="color4" href="login.html">Login</a></li>
          <li><a class="color4" href="login.html">Login</a></li>
          <li><a class="color4" href="login.html">Login</a></li>
        </ul>
      </div>

      <div class="clearfix"> </div>
    </div>
  </div>
</div>

<!-- products -->
<!-- grow -->
<div class="grow">
  <div class="container">
    <h2>Все модели</h2>
  </div>
</div>
<div class="container">


  <c:if test="${fn:length(products) eq 0}">
    <span class="home-block-name color-red"> - список пуст!</span>
  </c:if>
  <div class="grid-in">
    <c:if test="${fn:length(products) gt 0}">
    <c:forEach items="${products}" var="product">
    <div class="col-md-3 grid-top simpleCart_shelfItem">
      <a href="product_${product.url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/product/${product.photo.photoLinkShort}" alt="">

      </a>
      <p><a href="single.html">${product.title}</a></p>

      <form action="cart_add" method=post>
        <input type=hidden name="id" value="${product.id}">
        <p class="text" title="Добавить ${product.title} в корзину">
          <button class="btn btn-success" type="submit">Добавить в корзину</button>
        </p>
      </form>
    </div>
  </div>
  </c:forEach>
  </c:if>

</div>

<div class="footer w3layouts">
  <div class="container">
    <div class="footer-top-at w3">

      <div class="col-md-3 amet-sed w3l">
        <h4>MORE INFO</h4>
        <ul class="nav-bottom">
          <li><a href="#">How to order</a></li>
          <li><a href="#">FAQ</a></li>
          <li><a href="contact.html">Location</a></li>
          <li><a href="#">Shipping</a></li>
          <li><a href="#">Membership</a></li>
        </ul>
      </div>
      <div class="col-md-3 amet-sed w3ls">
        <h4>CATEGORIES</h4>
        <ul class="nav-bottom">
          <li><a href="#">Bed linen</a></li>
          <li><a href="#">Cushions</a></li>
          <li><a href="#">Duvets</a></li>
          <li><a href="#">Pillows</a></li>
          <li><a href="#">Protectors</a></li>
        </ul>

      </div>
      <div class="col-md-3 amet-sed agileits">
        <h4>NEWSLETTER</h4>
        <div class="stay agileinfo">
          <div class="stay-left wthree">
            <form action="#" method="post">
              <input type="text" placeholder="Enter your email " required="">
            </form>
          </div>
          <div class="btn-1 w3-agileits">
            <form action="#" method="post">
              <input type="submit" value="Subscribe">
            </form>
          </div>
          <div class="clearfix"> </div>
        </div>

      </div>
      <div class="col-md-3 amet-sed agileits-w3layouts">
        <h4>CONTACT US</h4>
        <p>Contrary to popular belief</p>
        <p>The standard chunk</p>
        <p>office :  +12 34 995 0792</p>
      </div>
      <div class="clearfix"> </div>
    </div>
  </div>
  <div class="footer-class w3-agile">
  </div>
</div>
<!-- Scripts -->
<script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/main.js" type="text/javascript"></script>

</body>
</html>

