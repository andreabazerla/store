$(document).ready(function() {

	$('.button-add-to-cart').click(function() {

		var formData = {
			idProduct : $(this).parents().children(":first-child").val(),
		};

		$.ajax({
			type : 'POST',
			url : 'addToCart.do',
			data : formData,
			conteType : 'application/json',
			dataType : 'json',
			success : function(data) {
				$('#product-' + data.idCard).closest('.product').hide();
			},
		});
	});

	$('.button-delete-product').click(function() {

		var formData = {
			idProduct : $(this).parents().children('.id-product').val(),
		};

		$.ajax({
			type : 'POST',
			url : 'DeleteProduct',
			data : formData,
			conteType : 'application/json',
			dataType : 'json',
			success : function(data) {
				console.log(data);
				$('#product-' + data.idProduct).closest('.product').hide();
			},
		});
	});

	$(document).ready(function() {

		$('.button-add-new-product').click(function() {

			var formData = {
				"name" : $('#name').val(),
				"description" : $('#description').val(),
				"price" : $('#price').val(),
				"type" : $('#type').val(),
				"console" : $('#console').val(),
				"date" : $('#date').val(),
				"gadge" : $('#gadge').val(),
				"model" : $('#model').val(),
				"factory" : $('#factory').val(),
				"year" : $('#year').val(),
				"genre" : $('#genre').val(),
			};

			$.ajax({
				type : 'POST',
				url : 'AddNewProduct',
				data : formData,
			});
		});

		$(".close-and-refresh").click(function() {
			location.reload();
		});

	});

});