<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Контакты</title>
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
    <h2>КОНТАКТЫ</h2>

  </div>
</div>

<!--content-->
<div class="contact">

  <div class="container">

    <div class="contact-form">

      <div class="col-md-8 contact-grid">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2540.7916397801673!2d30.44978091522526!3d50.44498157947467!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cc20b017f46b%3A0x8aec1f00dd88e166!2z0LLRg9C70LjRhtGPINCf0L7Qu9GM0L7QstCwLCAxMiwg0JrQuNGX0LI!5e0!3m2!1sru!2sua!4v1482691981753"
                width="700" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
      </div>
      <div class="col-md-4 contact-in">

        <div class="address-more">
          <br>
          <p>
          <p> <b>Адрес:</b></p>
          <p>  г. Киев, ул. Полевая, 12
          </p>
          <br>
          <p> <b>Телефон:</b></p>
          <p>
            (067) 224-19-25
          </p>
          <br>
          <p> <b>Email:</b></p>
          <p>
            <a href="mailto:info@alexcoffee.com.ua" target="_blank">sheverda_maxym@ukr.net</a>
          </p>
          <br>
        </div>
      </div>
      <div class="clearfix"> </div>
    </div>
  </div>
</div>

<!-- Footer -->
<jsp:include page="/WEB-INF/views/client/template/footer.jsp"/>
</body>
</html>
