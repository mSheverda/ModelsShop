<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="compress" uri="http://htmlcompressor.googlecode.com/taglib/compressor" %>

<compress:html>
    <html>
    <head>
      
<title>Авторизация || Models Shop</title>
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
			<h2>Авторизация</h2>
		</div>
	</div>
	
	<div class="container">
		<div class="account">
		<div class="account-pass">
		<div class="col-xs-6 col-xs-offset-4 col-sm-4 col-sm-offset-4 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4 col-xl-4 col-xl-offset-4 text-center">
		<c:if test="${param.error ne null}">
                        <div class="alert alert-info" role="alert">
                            Ошибка авторизации
                        </div>
                    </c:if>

                    <c:if test="${param.logout ne null}">
                        <div class="alert alert-info" role="alert">
                            Вы вышли из системы
                        </div>
                    </c:if>
					
				
			
			 <form class="form-signin" action="login"  method="post">
                        <input id="username" class="form-control" type="text" name="username"
                               pattern="[A-Za-z0-9_]{5,50}"
                               placeholder="Введите логин, формат (A-Z, a-z, 0-9, _)" style="margin-top: 25px"
                               minlength="5" maxlength="50" autofocus required>
                        <input id="password" class="form-control" type="password" name="password"
                               pattern="[A-Za-z0-9]{6,50}" placeholder="Введите пароль, формат (A-Z, a-z, 0-9)"
                               style="margin-top: 25px" minlength="6" maxlength="50" required>
                        <button class="btn btn-success" type="submit" style="margin-top: 25px">Войти</button>
                    </form>

		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

	</div>
	<div class="clearfix"> </div>
	</div>
	</div>

</div>
  	<!-- Footer -->
	<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>

    <!-- Scripts -->
    <script src="resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </body>
    </html>
</compress:html>