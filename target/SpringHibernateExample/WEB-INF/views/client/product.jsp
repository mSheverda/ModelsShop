<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



  <html>
  <head>
    <title>${product.title}</title>
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
<jsp:include page="/WEB-INF/views/client/template/home_header.jsp"/>
	
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
              <p><img src="../../../resources/images/product/${product.photo.photoLinkLong}"  width="465px"
			  
			  
                      class="hidden-xs hidden-sm" alt="${product.title}"></p>
            </c:if>

			
			
			
	<div class="clearfix"> </div>
	
	
					</div>	
					<div class="col-md-5 single-top-in simpleCart_shelfItem">
						
				<h5>Артикул: ${product.article}</h5>
            
              
			<br/>
			<h4>Характеристики</h4>
			
		
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

			<h1 align="center">ПОХОЖИЕ ТОВАРЫ</h1>
			<div class="grid-in">
				<c:forEach items="${featured_products}" var="featured_product">
						<div class="col-md-4 grid-top simpleCart_shelfItem">
							<a href="product_${featured_product.url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/product/${featured_product.photo.photoLinkShort}" alt="">

							</a>
							<p align="center"><a href="product_${featured_product.url}">${featured_product.title}</a></p>

							<form action="cart_add" method=post>
								<input type=hidden name="id" value="${featured_product.id}">
								<p class="text" title="Добавить ${featured_product.title} в корзину" align="center">
	<fmt:formatNumber type="number" value="${featured_product.price}"/> грн	&nbsp; <button class="btn btn-success" type="submit">Добавить в корзину</button>
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

<div class="container">
	<div class="col-xs-6 col-xs-offset-4 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4 col-xl-4 col-xl-offset-4 text-center">
		<br/>
		<h4 class="text-all-products text-shadow">
			<a href="all_products" title="Перейти ко всем товарам">Весь ассортимент моделей</a>
		</h4>
		<br/>
		<br/>
	</div>
</div>
		
  </div>
<!-- Footer -->
<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>
<!-- Scripts -->
<script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/main.js" type="text/javascript"></script>
  </body>
  </html>
