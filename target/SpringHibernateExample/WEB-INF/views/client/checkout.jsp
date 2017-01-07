<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>


  <html>
  <head>
    	
<title>Оформление заказа</title>
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
 <jsp:include page="/WEB-INF/views/client/template/home_header.jsp"/>
	
	<!-- grow -->
	<div class="grow">
		<div class="container">
			<h2>Заказ оформлен</h2>
		</div>
	</div>

  <!-- CHECKOUT -->
  <div class="container">
    <section id="checkout">
      <div class="row checkout">
        <div class="col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
          <div class="alert alert-info" role="alert">
            <b>${order.client.name}</b>, cпасибо за заказ!<br><br>
            Менеджер по продажам свяжется с Вами в ближайшее время!<br><br>
            Номер заказа: <b>${order.number}</b><br><br>
            Будем рады видеть Вас снова!<br><br>
            Телефон для связи с нами:<br><br>
            <br>+38(067)224-19-25<br>
            С уважением, команда <b>Models Shop</b>.<br>
          </div>
        </div>

        <!-- PRODUCTS IN ORDER -->
        <jsp:include page="/WEB-INF/views/client/template/products_in_the_cart.jsp"/>
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
  </body>
  </html>
