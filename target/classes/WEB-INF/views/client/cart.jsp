<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
  <html>
  <head>
<title>Корзина || Models Shop</title>
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

  <!-- NAVBAR -->
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
	
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>Корзина</h2>
		</div>
	</div>

  <!-- CART -->
  <div class="container-fluid width">
    <section id="cart">
      <div class="row cart">
        <div class="container">
          <div class="row section-name text-shadow color-brown">
            <b>
              
              <!-- EMPTY CART -->
              <c:if test="${fn:length(sale_positions) eq 0}">
                 <h2>Cписок пуст!</h2>
              </c:if>
            </b>
          </div>
        </div>

        <!-- FULL CART -->
        <c:if test="${fn:length(sale_positions) gt 0}">

          <!-- PRODUCTS IN THE CART -->
    <div class="container">
	<div class="check">
			 <h1>Товаров в корзине (${cart_size})</h1>
		 <div class="col-md-9 cart-items">
			
			<c:forEach items="${sale_positions}" var="position">
			 <div class="cart-header">
				 <div class="close1"> 
				 
				  <a href=""
                                           title="Удалить из корзины">
                                            <button class="btn btn-danger" type="submit">Удалить из корзины</button>
                                        </a>
										
				 </div>
				 <div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
					<a href="${position.product.url}" class="b-link-stripe b-animate-go  thickbox">
					<img class="img-responsive" src="../../../resources/images/product/${position.product.photo.photoLinkShort}" alt="">
					</a>
						</div>
					   
					   
				 
					   
					   
					   <div class="cart-item-info">
				<h2>		
			<a href="product_${position.product.url}" title="Перейти к ${position.product.title}">
                ${position.product.title}
            </a>	
			</h2>
						<h3>
						${position.product.article}
						
						</h3>
					
				<h2>	<fmt:formatNumber type="number" value="${position.product.price}"/> грн </h2>
						
							 <div class="delivery">
							 
							 
							 
							 <div class="clearfix"></div>
				        </div>	
					   </div>
					   <div class="clearfix"></div>
											
				  </div>
			 </div>
			 </c:forEach>
		
	   <div class="form-inline" margin: auto>
            <form action="checkout" method="post">
              
                <input class="form-control" type="text" name="user_name" placeholder=" Введите имя"
                       minlength="2" maxlength="50" required autofocus>
              
                <input class="form-control" class="phone input" type="text" name="user_phone" placeholder=" 000-000-00-00"
                       required>
              
                <input class="form-control" type="email" name="user_email" placeholder=" Введите Email"
                       minlength="5" maxlength="50">
              
              
                <input type="submit" class="btn btn-success" value="Оформить заказ" width="80px">
              
            </form>
          </div>
		
		 </div>
		 
		  <div class="col-md-3 cart-total">
		
			 <div class="price-details">
				 <h3> Всего: <fmt:formatNumber type="number" value="${price_of_cart}"/> грн</h3>
							 
			 </div>	
			 <div class="clearfix"></div>
			 
			
			<a class="order" href="all_products">
                Продолжить покупки
              </a>
              <a class="order" href="cart_clear">
                Очистить корзину
              </a>
			
			</div>
		
			<div class="clearfix"> </div>
	 </div>
	 </div>

		  
		  
          <!-- Order registration 
          <div class="row">
            <form action="checkout" method="post">
              <div class="col-xs-12 col-sm-2 col-sm-offset-2 col-md-2 col-md-offset-2 col-lg-2 col-lg-offset-2 col-xl-2 col-xl-offset-2 input-padding text-center">
                <input class="input" type="text" name="user_name" placeholder=" Введите имя"
                       minlength="2" maxlength="50" required autofocus>
              </div>
              <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">
                <input class="phone input" type="text" name="user_phone" placeholder=" Введите телефон"
                       required>
              </div>
              <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">
                <input class="input" type="email" name="user_email" placeholder=" Введите Email"
                       minlength="5" maxlength="50">
              </div>
              <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2 col-xl-2 input-padding text-center">
                <input type="submit" class="btn btn-success" value="Оформить заказ" width="80px">
              </div>
            </form>
          </div>
-->
          
        </c:if>
      </div>
    </section>
  </div>

  <!-- FOOTER -->

  <!-- Scripts -->
  <script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/main.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/jquery.maskedinput.min.js" type="text/javascript"></script>
  </body>
  </html>
</compress:html>