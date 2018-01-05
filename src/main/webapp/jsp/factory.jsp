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

<script src="<c:url value='/js/productAction.js' />"></script>

</head>

<body id="body">

	<%@ include file="/jsp/partials/navbar.jspf"%>

	<div class="container">

		<h1>
			<c:out value="${pageBean.beanFactory.name}"></c:out>
		</h1>

		<c:if test="${currentUser.role == 'ADMIN'}">
			<br>

			<form action="DeleteFactory" method="POST">
				<input type="submit" class="btn btn-primary" value="Delete factory" />
				<input type="hidden" name="id-factory"
					value='<c:out value="${pageBean.beanFactory.id}"></c:out>' />
			</form>

			<br>
		</c:if>

		<c:if test="${pageBean.beanFactory.beanProductList != null}">
			<c:forEach var="beanProduct"
				items="${pageBean.beanFactory.beanProductList}">
				<%@ include file="/jsp/partials/productFactory.jspf"%>
			</c:forEach>
		</c:if>

	</div>

</body>

</html>