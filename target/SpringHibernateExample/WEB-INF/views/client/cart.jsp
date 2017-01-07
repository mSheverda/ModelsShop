<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Корзина</title>
	<jsp:include page="/WEB-INF/views/admin/head.jsp"/>
</head>
<body>
<!--header-->
<jsp:include page="/WEB-INF/views/client/template/home_header.jsp"/>

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
						<br/><br/>
						<h2>Cписок пуст!</h2>
						<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
						</c:if>
					</br>
				</div>
			</div>

			<!-- FULL CART -->
			<c:if test="${fn:length(sale_positions) gt 0}">

				<!-- PRODUCTS IN THE CART -->
				<div class="container">
					<div class="check">
						<h1>Товаров в корзине (${cart_size})</h1>
						<div class="col-md-9 cart-items">

							<c:forEach items="${sale_positions}" var="position" varStatus="loop">

								<div class="cart-header">
									<div class="close1">

										<h5>Кол-во</h5>
										<form action="update_quantity_${loop.index}" method="post">
										<input type="text" size="5" style="text-align:right;" name="quantity" pattern="[0-9]{1,2}"  value="${position.number}"
											   placeholder="00" maxlength="6" required/>

											<button class="btn btn-success" type="submit">ОК</button>
										</form>
										<a href="delete_saleposition_${loop.index}"
										   title="Удалить позицию ${position.product.title}">
											<button class="btn btn-danger" type="submit">Удалить</button>
										</a>

									</div>
									<div class="cart-sec simpleCart_shelfItem">
										<div class="cart-item cyc">
											<a href="product_${position.product.url}" class="b-link-stripe b-animate-go  thickbox">
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
												Артикул: ${position.product.article}
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

									<input class="form-control" class="phone input" type="text" name="user_phone" pattern="380([0-9]){2}-([0-9]){3}-([0-9]){2}-([0-9]){2}" placeholder="380XX-XXX-XX-XX"
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
			</c:if>
			<br/><br/><br/><br/><br/><br/><br/><br/><br/>
		</div>
	</section>
</div>

<!-- Footer -->
<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>
<!-- Scripts -->
<script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/main.js" type="text/javascript"></script>
<script src="resources/bootstrap/js/jquery.maskedinput.min.js" type="text/javascript"></script>
</body>
</html>
