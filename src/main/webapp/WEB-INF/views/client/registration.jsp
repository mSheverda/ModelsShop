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
  <title>?????????? ????????</title>

  <style>

    .error {
      color: #ff0000;
    }
  </style>

</head>

<body>

<h2>Новый сотрудник</h2>

<div class="container-fluid width">
  <section id="category">
    <div class="row admin-page">
      <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1">
        <div class="row section-name text-shadow">
          <b>
            <span class="color-green">??????? </span>
            <span class="color-brown"></span>
          </b>
        </div>
      </div>

      <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1 col-xl-10 col-xl-offset-1 full-cart">
        <form enctype="multipart/form-data" action="new" method="post">
          <table class="table">

            <tr>
              <th>???:</th>
              <td>
                <input class="input-order" type="text" name="url"

                       minlength="5" maxlength="50" required>
              </td>
            </tr>

            <tr>
              <td colspan="3">
                <c:choose>
                  <c:when test="${edit}">
                    <input type="submit" value="?????????????"/>
                  </c:when>
                  <c:otherwise>
                    <input type="submit" value="????????"/>
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>

          </table>
        </form>
      </div>
    </div>
  </section>
</div>

<br/>
<br/>
???????? ? <a href="<c:url value='/list' />">?????? ?????????</a>
</body>
</html>