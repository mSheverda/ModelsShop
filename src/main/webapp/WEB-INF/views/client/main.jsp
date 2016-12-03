<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
  <meta charset="utf-8">
  <meta lang="ru">
  <meta url="viewport" content="width=device-width, initial-scale=1">
  <meta url="robots" content="index,follow">
  <meta url="google-site-verification" content="qiZQeYKdNTO5NVZQisl_gpnbTUCB89tSrwzSo99-fNo"/>
  <title>Models Shop</title>
  <!-- Favicon -->
  <link rel="shortcut icon" href="/resources/img/favicon.ico" type="image/x-icon">
  <link rel="icon" href="/resources/img/favicon.ico" type="image/x-icon">
  <!-- Styles -->
  <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="/resources/bootstrap/css/animate.css" rel="stylesheet" type="text/css">
  <link href="/resources/bootstrap/css/style.css" rel="stylesheet" type="text/css">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"
        type="text/css">
  <!-- Scripts -->
  <script src="/resources/bootstrap/js/jquery-1.11.1.min.js" type="text/javascript"></script>
  <script src="/resources/bootstrap/js/jquery.appear.js" type="text/javascript"></script>
  <script src="/resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="/resources/bootstrap/js/main.js" type="text/javascript"></script>

</head>

<body>

<jsp:include page="/WEB-INF/views/client/template/home_navbar.jsp"/>

<!-- Main logo -->
<div class="container-fluid width">
  <section id="main">
    <div class="row main text-shadow">   <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>

        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
          <div class="item active">
            <img src="resources/img/carusel/1.jpg" alt="Chania">
          </div>

         <div class="item">
            <img src="resources/img/carusel/2.jpg" alt="Flower">
          </div>

       </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div></div>
  </section>


</div>

<div class="container">

  <h2>Список продуктов</h2>

  <c:forEach items="${products}" var="product">
    <tr>
      <td>${product.url}</td>
      <td>${product.year}</td>
    </tr>
  </c:forEach>

<br/>
<a href="<c:url value='/new' />">Добавить продукт</a>

  <br/>
  <a href="<c:url value='/admin' />">Админка</a>

</div>

</body>

</html>