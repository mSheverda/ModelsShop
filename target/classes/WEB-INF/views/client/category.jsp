<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <html>
    <head>
<title>${category.title}</title>
		<jsp:include page="/WEB-INF/views/admin/head.jsp"/>
    
	</head>
    <body>
<!--header-->
<jsp:include page="/WEB-INF/views/client/template/home_header.jsp"/>

	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>${category.title}</h2>
		</div>
	</div>
	<div class="container">
	
		
	<c:if test="${fn:length(products) eq 0}">
		<br/>
		<br/>
		<h2>Cписок пуст!</h2>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	</c:if>



		<div class="grid-in">

			<c:if test="${fn:length(products) gt 0}">
				<c:forEach items="${products}" var="product">
					<div class="col-md-3 grid-top simpleCart_shelfItem">
						<a href="product_${product.url}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="../../../resources/images/product/${product.photo.photoLinkShort}" alt="">

						</a>
						<p style="text-align:center;"><a href="product_${product.url}">${product.title}</a></p>
						<form action="cart_add" method=post>
							<input type=hidden name="id" value="${product.id}">
							<p class="text" style="text-align:center;" title="Добавить ${product.title} в корзину">
								<fmt:formatNumber type="number" value="${product.price}"/> грн	&nbsp;   <button class="btn btn-success" type="submit">Добавить в корзину</button>
							</p>
						</form>

					</div>
				</c:forEach>
			</c:if>


			<div class="clearfix"> </div>
		</div>
</div>
		
		
<div class="clearfix"> </div>
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

<!-- Footer -->
<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>

    <!-- Scripts -->
    <script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/main.js" type="text/javascript"></script>

    </body>
    </html>

