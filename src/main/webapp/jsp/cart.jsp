<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/style.css' />">


<script type="text/javascript">
	$(document).ready(function() {

		$('.button-remove-from-cart').click(function() {

			$.ajax({
				type : 'POST',
				url : 'RemoveFromCart',
				conteType : 'application/json',
				dataType : 'json',
				data : {
					productId : $(this).parent().children(":first-child").val()
				},
				success : function(data) {
					$('#id-card-' + data.idCard).closest('.card').hide();
					location.reload();
				},
			});
		});
	});
</script>

</head>

<body id="body">

	<%@ include file="/jsp/partials/navbar.jspf"%>

	<div class="container" id="total">
		<div class="row">
			<div class="col-8">
				<c:if test="${pageBean.beanProductList != null}">
					<div class="product-list">
						<c:forEach var="beanProduct" items="${pageBean.beanProductList}">
							<%@ include file="/jsp/partials/productCartPreview.jspf"%>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<div class="cart-block col-4">
				<h1>Cart</h1>

				<br>

				<c:forEach var="beanProduct" items="${pageBean.beanProductList}">

					<div style="display: block;">
						<h4>
							<c:out value="${beanProduct.name} - $${beanProduct.price}"></c:out>
						</h4>
					</div>

				</c:forEach>

				<br>

				<h2 style="">
					&dollar;
					<c:out value="${pageBean.total}"></c:out>
				</h2>

				<br>

				<form action="Buy" method="POST">
					<input type="submit" class="btn btn-primary" value="Buy">
				</form>
			</div>
		</div>
	</div>

</body>

</html>