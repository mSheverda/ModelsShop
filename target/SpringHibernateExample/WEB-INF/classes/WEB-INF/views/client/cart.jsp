<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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


        </c:if>
      </div>
    </section>
  </div>

  <!-- FOOTER -->
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
  <!-- Scripts -->
  <script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/main.js" type="text/javascript"></script>
  <script src="resources/bootstrap/js/jquery.maskedinput.min.js" type="text/javascript"></script>
  </body>
  </html>
