<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<title>Магазин моделей</title>
	<jsp:include page="/WEB-INF/views/admin/head.jsp"/>
</head>
<body>
<!--header-->
<jsp:include page="/WEB-INF/views/client/template/home_header.jsp"/>

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
			<section id="categories">
				<h2>Категории</h2>
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
							<a href="category_${categories[2].url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/category/${categories[2].photo.photoLinkShort}" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>${categories[2].title}</span>
											</h3>
										</div>
							</a>
							
						</div>
						<div class="col-md-6 men2">
							<a href="category_${categories[3].url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/category/${categories[3].photo.photoLinkShort}" alt="">
									<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in2   b-delay03 ">
												<span>${categories[3].title}</span>
											</h3>
										</div>
							</a>
							
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				
				</c:if>
				<div class="clearfix"> </div>
				</section>
			</div>
			<div class="content-top">
			<section id="products">
				<h1>ПОПУЛЯРНЫЕ ТОВАРЫ</h1>
				
		   
		   				
				<div class="grid-in">
					
	<c:if test="${fn:length(products) gt 0}">
    <c:forEach items="${products}" var="product">	
					<div class="col-md-3 grid-top simpleCart_shelfItem">					
						<a href="product_${product.url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/product/${product.photo.photoLinkShort}" alt="">
							
						</a>
					<p><a href="product_${product.url}">${product.title}</a></p>
					
			<form action="cart_add" method=post>
              <input type=hidden name="id" value="${product.id}">
              <p class="text" title="Добавить ${product.title} в корзину">
				  <fmt:formatNumber type="number" value="${product.price}"/> грн	&nbsp;   <button class="btn btn-success" type="submit">Добавить в корзину</button>
              </p>
            </form>
					
					</div>					
					</c:forEach>
</c:if>
					<div class="clearfix"> </div>
				</div>
			</section>

					<div class="col-xs-6 col-xs-offset-4 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4 col-xl-4 col-xl-offset-4 text-center">
						<br/>
						<h4 class="text-all-products text-shadow">
							<a href="all_products" title="Перейти ко всем товарам">Весь ассортимент моделей</a>
						</h4>
						<br/>

					</div>


			</div>
		</div>
	</div>
	<!-- Scripts -->
    <script src="http://maps.google.com/maps/api/js?sensor=false"></script>
</div>
<!-- Footer -->
<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>
</body>
</html>