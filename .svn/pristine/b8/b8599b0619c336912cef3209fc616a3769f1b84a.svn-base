<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

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

</head>

<body id="body">

	<%@ include file="/jsp/partials/navbar.jspf"%>

	<div class="container">

		<div class="product-list">
			<c:forEach var="entry" items="${pageBean.beanReceiptPurchaseMap}">

				<div class="purchase">

					<c:if test="${entry.key.flag == 0}">
						<div class="" style="display: block; clear: both;">
							<form action="PrintReceipt" method="POST" class="shopping-button">
								<input type="submit" name="print-receipt"
									class="btn btn-primary print-receipt" value="Print receipt" />
								<input type="hidden" name="id-receipt"
									value='<c:out value="${entry.key.id}"></c:out>' />
							</form>

							<form action="DeletePurchase" method="POST"
								class="shopping-button">
								<input type="submit" name="delete-purchase"
									class="btn btn-secondary delete-purchase"
									value="Delete purchase" />
								<input type="hidden" name="id-receipt"
									value='<c:out value="${entry.key.id}"></c:out>' />
							</form>
						</div>
					</c:if>

					<div class="" style="clear: both;">
						<c:forEach var="beanProduct"
							items="${entry.value.beanProductPreviewList}">
							<%@ include file="/jsp/partials/productShoppingNotReceipt.jspf"%>
						</c:forEach>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>

</body>

</html>