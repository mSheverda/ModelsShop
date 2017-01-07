<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  <html>
  <head>
    	
<title>Оформление заказа</title>
      <jsp:include page="/WEB-INF/views/admin/head.jsp"/>
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
          <div class="container">
              <div class="row">

                  <table class="table cart-table">
                      <tr>
                          <th>Название</th>
                          <th>Кол.</th>
                          <th>Категория</th>
                          <th>Стоимость</th>
                      </tr>
                      <c:forEach items="${sale_positions}" var="position">
                          <tr>
                              <td>
                                  <a href="product_${position.product.url}" title="Перейти к ${position.product.title}">
                                          ${position.product.title}
                                  </a>
                              </td>
                              <td>${position.number}</td>
                              <td>
                                  <a href="category_${position.product.category.url}"
                                     title="Перейти к категории ${position.product.category.title}">
                                          ${position.product.category.title}</a>
                              </td>
                              <td>
                                  <fmt:formatNumber type="number" value="${position.product.price}"/> грн
                              </td>
                          </tr>
                      </c:forEach>
                      <tr>
                          <td></td>
                          <td></td>
                          <td></td>
                          <td style="text-align: right;"><strong>Итого:</strong></td>
                          <td><b><fmt:formatNumber type="number" value="${price_of_cart}"/> грн</b></td>
                      </tr>
                  </table>
              </div>
          </div>
          <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
