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
		<div class="row">

			<div class="col-sm-6 col-md-4 mb-5">
				<img src="http://via.placeholder.com/300x300.png"
					class="product-image">
			</div>

			<div class="col-sm-6 col-md-8">
				<div class="row">
					<div class="col">
						<h1>Product</h1>
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Name</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.name}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Description</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.description}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Price</div>
					<div class="field-value col-md-8">
						&dollar;
						<c:out value="${pageBean.price}"></c:out>
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Type</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.type}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Console</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.console}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Date</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.date}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Gadge</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.gadge}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Model</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.model}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Factory</div>
					<div class="field-value col-md-8">
						<%-- <a href="Factory?id=<c:out value='${pageBean.factory.id}' />"><c:out
								value="${pageBean.factory.name}" /></a> --%>
						<a
							href="http://localhost:8080/Store/Home?factory=<c:out value='${pageBean.factory.id}' />" /><c:out value="${pageBean.factory.name}" /></a>

					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Build</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.build}" />
					</div>
				</div>

				<div class="field-row row">
					<div class="field-name col-md-4">Genre</div>
					<div class="field-value col-md-8">
						<c:out value="${pageBean.genre}" />
					</div>
				</div>

				<c:if test="${currentUser.role == 'ADMIN'}">
					<div class="field-row row">
						<div class="field-value col">
							<form action="EditAdmin" method="POST">
								<button type="submit" class="btn btn-primary">Edit</button>
								<input type="hidden" name="action" value="EDIT_ADMIN">
							</form>
						</div>
					</div>
				</c:if>

			</div>

		</div>
	</div>

</body>

</html>