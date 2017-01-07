<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Контакты</title>
  <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
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
          <p><b>Адрес:</b></p>
          <p>г. Киев, ул. Полевая, 12
          </p>
          <br>
          <p><b>Телефон:</b></p>
          <p>
            (067) 224-19-25
          </p>
          <br>
          <p><b>Email:</b></p>
          <p>
            <a href="mailto:sheverda_maxym@ukr.net" target="_blank">sheverda_maxym@ukr.net</a>
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
