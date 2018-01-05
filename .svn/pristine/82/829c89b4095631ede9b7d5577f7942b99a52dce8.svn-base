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

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.0.0/bootstrap-slider.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/10.0.0/css/bootstrap-slider.css">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/style.css' />">

<script src="<c:url value='/js/productAction.js' />"></script>

</head>

<body id="body">

	<script type="text/javascript">
		$(document).ready(function() {

			$("#input-price-search").slider({
				tooltip : 'show',
			});

			$('.input-slider').on('change', function() {
				var price = $('#input-price-search').val();

				var priceArray = price.split(',');
				var min = priceArray[0];
				var max = priceArray[1];

				$('.price-min-text').html('&dollar; ' + min);
				$('.price-max-text').html('&dollar; ' + max);
			});
		});

		/* $(document)
				.ready(
						function() {

							function setUrl(json) {
								let url = [];
								for ( let param in json) {
									if (json[param] != '') {
										url
												.push(encodeURIComponent(param)
														+ '='
														+ encodeURIComponent(json[param]));
									}
								}
								return url.join('&');
							}
							;

							$("#input-price-search").slider({
								tooltip : 'show',
							});

							$('.input-text, .input-dropdown, .input-slider')
									.on(
											'change',
											function() {
												
												var name = $(
														'#input-name-search')
														.val();
												var description = $(
														'#input-description-search')
														.val();
												var factory = $(
														'#input-factory-search')
														.val();
												var price = $(
														'#input-price-search')
														.val();
																								
												var priceArray = price.split(',');
												var min = priceArray[0];
												var max = priceArray[1];
												
												$('.price-min-text').html('&dollar; ' + min);
												$('.price-max-text').html('&dollar; ' + max);

												var json = {
													name : name,
													description : description,
													factory : factory,
													min : min,
													max : max
												};

												clearTimeout(timer);
												timer = setTimeout(function() {
													search(json);
												}, 1000);
											});

							var timer = null;

							function search(json) {
								$.ajax({
									type : 'GET',
									url : 'Home',
									data : json,
									success : function() {
										var url = setUrl(json);

										if (url != '')
											url = 'Home?' + url;
										else
											url = 'Home';

										window.location.href = url;
									}
								});
							}

						}); */
	</script>

	<%@ include file="/jsp/partials/navbar.jspf"%>

	<div class="container">

		<div class="modal fade" id="modal-new-product" tabindex="-1"
			role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="modalLabel">Store</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div id="feedbackStore" class="alert" role="alert"
							style="display: none"></div>
						<form action="AddNewProduct" method="POST">
							<div class="form-group">
								<label for="name">Name</label> <input type="text" id="name"
									name="name" class="form-control" required value="Test" />
							</div>
							<div class="form-group">
								<label for="description">Description</label>
								<textarea type="text" id="description" name="description"
									class="form-control" rows="3" required>Test</textarea>
							</div>
							<div class="form-group">
								<label for="price">Price</label>
								<div class="input-group">
									<span class="input-group-addon">$</span> <input type="text"
										id="price" class="form-control" value="100"> <span
										class="input-group-addon">.00</span>
								</div>
							</div>
							<div class="form-group">
								<label for="type">Type</label> <select id="type"
									class="form-control">
									<option></option>
									<option selected>TEST</option>
									<option>SOFTWARE</option>
									<option>GAME</option>
									<option>OTHERS</option>
								</select>
							</div>
							<div class="form-group">
								<label for="console">Console</label> <select id="console"
									class="form-control">
									<option></option>
									<option selected>TEST</option>
									<option>PC</option>
									<option>PLAYSTATION</option>
									<option>XBOX</option>
								</select>
							</div>
							<div class="form-group">
								<label for="date">Date</label> <input type="date" id="date"
									class="form-control" required value="2017-12-01" />
							</div>
							<div class="form-group">
								<label for="gadge">Gadge</label> <select id="gadge"
									class="form-control">
									<option></option>
									<option selected>TEST</option>
									<option>BASIC</option>
									<option>PREMIUM</option>
								</select>
							</div>
							<div class="form-group">
								<label for="model">Model</label> <input type="model" id="model"
									name="model" min="1" value="1" step="1" class="form-control"
									required />
							</div>
							<div class="form-group">
								<label for="factory">Factory</label> <select id="factory"
									class="form-control">
									<option></option>
									<option value="0">ZUCCHETTI</option>
									<option value="1" selected>TEST</option>
									<option value="2">UBISOFT</option>
									<option value="3">GOOGLE</option>
								</select>
							</div>
							<div class="form-group">
								<label for="year">Year</label> <input type="number" id="year"
									name="year" min="1900" max="2017" value="2017" step="1"
									class="form-control" required />
							</div>
							<div class="form-group">
								<label for="genre">Genre</label> <select id="genre"
									class="form-control">
									<option></option>
									<option selected>TEST</option>
									<option>ADVENTURE</option>
									<option>BUSINESS</option>
									<option>GRAPHIC</option>
									<option>HISTORY</option>
									<option>OS</option>
								</select>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button"
							class="btn btn-primary button-add-new-product">Add</button>
						<button type="button" class="btn btn-secondary close-and-refresh"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<button id="button-new-product" type="button" data-toggle="modal"
			data-target="#modal-new-product" class="btn btn-primary">Add
			new product</button>

		<br> <br>

		<div class="row">
			<div class="col-9">
				<c:if test="${pageBean.beanProductList != null}">
					<div class="product-list">
						<c:forEach var="beanProduct" items="${pageBean.beanProductList}">
							<%@ include file="/jsp/partials/productHome.jspf"%>
						</c:forEach>
					</div>
				</c:if>
			</div>
			<div class="cart-block col-3">
				<h1>Search</h1>
				<form action="Home" method="GET">
					<div class="form-group">
						<label for="input-name-search">Name</label> <input
							class="form-control input-text" type="text" placeholder=""
							name="name" id="input-name-search" autocomplete="off"
							value="<c:out value='${pageBean.beanSearch.name}'></c:out>" />
					</div>


					<div class="form-group">
						<label for="input-description-search">Description</label> <input
							class="form-control input-text" type="text" placeholder=""
							name="description" id="input-description-search" autocomplete="off"
							value="<c:out value='${pageBean.beanSearch.description}'></c:out>" />
					</div>

					<div class="form-group">
						<label for="input-price-search">Price</label>

						<c:choose>
							<c:when test="${pageBean.beanSearch.min != 0}">
								<b class="price-min-text">&dollar; <c:out
										value="${pageBean.beanSearch.min}"></c:out></b>
							</c:when>
							<c:otherwise>
								<b class="price-min-text">&dollar; 0</b>
							</c:otherwise>
						</c:choose>

						<input name="price" id="input-price-search" type="text" class="input-slider"
							value="" data-slider-min="0" data-slider-max="1000"
							data-slider-step="1"
							<c:choose>
							<c:when test="${pageBean.beanSearch.min == 0 && pageBean.beanSearch.max == 0}">
								<c:out value="data-slider-value=[0,1000]"></c:out>
							</c:when>
							<c:otherwise>
								<c:out value="data-slider-value=[${pageBean.beanSearch.min},${pageBean.beanSearch.max}]"></c:out>
							</c:otherwise>
						</c:choose> />

						<c:choose>
							<c:when test="${pageBean.beanSearch.max != 0}">
								<b class="price-max-text">&dollar; <c:out
										value="${pageBean.beanSearch.max}"></c:out></b>
							</c:when>
							<c:otherwise>
								<b class="price-max-text">&dollar; 1000</b>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="form-group">
						<label for="input-factory-search">Factory</label> <select name="factory"
							class="form-control input-dropdown" id="input-factory-search">
							<option></option>
							<c:forEach var="beanFactory"
								items="${pageBean.beanSearch.beanFactorySet}">
								<option value="<c:out value="${beanFactory.id}"></c:out>"><c:out value="${beanFactory.name}"></c:out></option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-primary">Search</button>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#input-factory-search').val("<c:out value='${pageBean.beanSearch.factory}'></c:out>");
		});
	</script>

</body>

</html>