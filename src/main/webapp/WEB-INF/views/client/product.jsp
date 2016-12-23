<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
  <html>
  <head>
    <title>single</title>
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
<script src="../../../resources/js/imagezoom.js"></script>
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
	
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>${product.title}</h2>
		</div>
	</div>

	
	
		<!-- grow -->
		<div class="product">
			<div class="container">
				
				<div class="product-price1">
				<div class="top-sing">
				<div class="col-md-7 single-top">	
				<c:if test="${(product.photo.photoLinkLong ne null) and (product.photo.photoLinkLong ne '')}">
              <p><img src="../../../resources/images/product/${product.photo.photoLinkLong}"  width="465px" <!--  height="465px" -->
			  
			  
                      class="hidden-xs hidden-sm" alt="${product.title}"></p>
            </c:if>

			
			
			
	<div class="clearfix"> </div>
	
	
					</div>	
					<div class="col-md-5 single-top-in simpleCart_shelfItem">
						
				<h5>Артикул: ${product.article}</h5>
            
              
			<br/>
			<p fontSize: 25px> <b>Характеристики</b></p>
			
		
<table class="my-table">
<tr>
	<td  width = "25%">Производитель</td>
	<td width = "30%" >${product.manufacturer}</td>
</tr>
<tr>
	<td  width = "25%">Сложность</td>
	<td width = "30%" >${product.difficulty}</td>
</tr>
<tr>
	<td  width = "25%">Масштаб</td>
	<td width = "30%" >${product.scale}</td>
</tr>
<tr>
	<td  width = "25%">Кол-во деталей</td>
	<td width = "30%" >${product.details}</td>
</tr>
</table>
            	<br/>		
			<c:if test="${(product.description ne null) and (product.description ne '')}">
              <br>
              <p fontSize: 25px><b>Описание</b></p>
              <p fontSize: 25px>${product.description}</p>
            </c:if>
			<br/>
			<h3>
			<p class="price-product">
                <fmt:formatNumber type="number" value="${product.price}"/> грн
            </p>
            </h3>
			<br/>
            <form action="cart_add" method=post>
              <input type=hidden name="id" value="${product.id}">
              <p class="text" title="Добавить ${product.title} в корзину">
                <button class="btn btn-success" type="submit">Добавить в корзину</button>
              </p>
            </form>		
			
					</div>
				<div class="clearfix"> </div>
				</div>
			<!---->

		<c:if test="${fn:length(featured_products) gt 0}">	
		<div class=" bottom-product">
				<c:forEach items="${featured_products}" var="featured_product">	
					<div class="col-md-4 bottom-cd simpleCart_shelfItem">
						<div class="product-at ">
						<a href="product_${featured_product.url}"
                     title="Перейти к ${featured_product.title}">
                    <img src="resources/img/${featured_product.photo.photoLinkShort}"
                         alt="${featured_product.title}"
                         class="img-thumbnail blink" width="185px" height="185px">
                    <div class="text-shadow">
                        ${featured_product.title}
                    </div>
                    <p class="price-top">
                      <fmt:formatNumber type="number" value="${featured_product.price}"/> грн
                    </p>
                  </a>	
						</div>
						<br/>
						<div class="ca-rt">
							<a href="#" class="item_add"><p class="number item_price"><i> </i>$500.00</p></a>						
						</div>						
						
						<form action="cart_add" method=post>
              <input type=hidden name="id" value="${featured_product.id}">
              <p class="text" title="Добавить ${featured_product.title} в корзину">
                <button class="btn btn-success" type="submit">Добавить в корзину</button>
              </p>
            </form>
						
					</div>
				</c:forEach>	

						
					<div class="clearfix"> </div>
		</div>
		</c:if>		
				
</div>

		<div class="clearfix"> </div>
		</div>
		</div>
		
		
		
  </div>

  <!-- FOOTER -->

  <!-- Scripts -->
  <script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/main.js" type="text/javascript"></script>
  
  <div class="footer w3layouts">
				<div class="container">
			<div class="footer-top-at w3">
			
				<div class="col-md-3 amet-sed w3l">
				<h4>ИНФОРМАЦИЯ</h4>
				<ul class="nav-bottom">
						<li><a href="#">Оплата</a></li>
						<li><a href="#">Доставка</a></li>
						<li><a href="contact.html">Контакты</a></li>						
					</ul>	
				</div>
				<div class="col-md-3 amet-sed w3ls">
					<h4>КАТЕГОРИИ</h4>
					<ul class="nav-bottom">
						<li><a href="#">Танки</a></li>
						
					</ul>
					
				</div>
				<div class="col-md-3 amet-sed agileits-w3layouts">
				<h4>ПОЗВОНИТЕ НАМ</h4>					
					<p>Офис :  +38 067 224 19 25</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="footer-class w3-agile">		
		</div>
		</div>
  </body>
  </html>
</compress:html>
