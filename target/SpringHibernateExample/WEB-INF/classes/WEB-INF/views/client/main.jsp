<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Home</title>
<link href="../../../resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../../resources/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="../../../resources/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	<div class="banner">
		<div class="container">
			  <script src="js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">			    
				<li>
						<div class="banner-text">
							<h3>Магазин моделей</h3>
						</div>					
				</li>
			</ul>
		</div>
	</div>
	</div>

<!--content-->
<div class="container">
	<div class="cont">
		<div class="content">
			<div class="content-top-bottom">
			
				<h2>Категории
				<c:if test="${fn:length(categories) eq 0}">
					<span> - список пуст!</span>
                </c:if>
				</h2>
				<c:if test="${fn:length(categories) gt 0}">
   					
				<div class="col-md-6 men">
					<a href="category_${categories[1].url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/category/${categories[1].photo.photoLinkShort}" alt="">
						<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in   b-delay03 ">
												<span>${categories[1].title}</span>	
											</h3>
										</div>
					</a>									
				</div>
				<div class="col-md-6">
					<div class="col-md1 ">
						<a href="category_${categories[0].url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/category/${categories[0].photo.photoLinkShort}" alt="">
							<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in1   b-delay03 ">
												<span>${categories[0].title}</span>	
											</h3>
										</div>
						</a>
						
					</div>
					<div class="col-md2">
						<div class="col-md-6 men1">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/t3.jpg" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>Самолеты</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="col-md-6 men2">
							<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/t4.jpg" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>Корабли</span>	
											</h3>
										</div>
							</a>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				
				</c:if>
				<div class="clearfix"> </div>
				
			</div>
			<div class="content-top">
				<h1>ПОПУЛЯРНЫЕ ТОВАРЫ</h1>
					
				
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
					</c:forEach>
</c:if>	
					
					
					<div class="clearfix"> </div>
				</div>
			</div>
		</div>
	<!----->
	</div>
	<!---->
</div>
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