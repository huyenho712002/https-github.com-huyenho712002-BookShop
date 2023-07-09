<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>Product Form</title>

<body>
	<div class="container" style="text-align: center">
		<h2 style="font-size: 40pt ; margin-top: 50px">PRODUCT</h2>

		<!-- Trigger the modal with a button -->
		<button style="float: right" type="button" class="btn btn-info btn-lg btn-add"
			data-toggle="modal" data-target="#myModalAddProduct">Add
			Product</button><br><br><br>

			<input style="height: 2rem" class="form-control "
			id="myInput" type="text" placeholder="Search.."> <br>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên Sách</th>
					<th>Hình Ảnh</th>
					<th>Miêu Tả</th>
					<th style="width: 30%">Actions</th>
				</tr>
			</thead>
			<tbody id="myTable">
				<c:forEach var="product" items="${listProduct}">
					<tr>
						<td>${product.bookId}</td>
						<td>${product.bookName}</td>
						<td>${product.img }
						<td>${product.description}</td>
						<td>
							<button style="margin-right: 20px" type="button"
								class="btn btn-warning btn-lg edit" data-toggle="modal"
								data-target="#myModalEditProduct">Edit Product</button>

							<button type="button" class="btn btn-danger btn-lg delete"
								data-toggle="modal" data-target="#myModalDeleteProduct">Delete</button>
							<input type="hidden" id="idProduct" value="${product.bookId}">
							<input type="hidden" id="nameProduct" value="${product.bookName}">
							<input type="hidden" id="img" value="${products.img}">
							<input type="hidden" id="descriptionProduct"
							value="${product.description}">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<!-- Modal Delete Product -->
	<div id="myModalDeleteProduct" class="modal fade"
		style="background-color: transparent !important" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form id="formDelete" action="" method="get">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Detele Product</h4>
					</div>
					<div class="modal-body">
						<p>Bạn Có chắc muốn xoá Product này không ?</p>

					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success btn-lg">Delete</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

					</div>
				</form>
			</div>

		</div>
	</div>




	<!-- Modal Add Product -->
	<div id="myModalAddProduct" class="modal fade"
		style="background-color: transparent !important" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form:form action="product/add" method="post" modelAttribute="product">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Product</h4>
					</div>
					<div class="modal-body">

						<div class="form-group">
							<label for="nameProduct">Name:</label> <input type="text"
								style="height: 2rem" class="form-control" id="nameAddProduct"
								placeholder="Enter name" name="name" required min="3" max="50">
						</div>
						<div class="form-group">
							<label for="descriptionProduct">Description:</label> <input
								type="text" class="form-control" style="height: 2rem;"
								id="descriptionAddProduct" placeholder="Enter Description"
								name="description">
						</div>
						
						<div class="form-group">
							<label for="priceProduct">Price:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="priceEditProduct"
								placeholder="Enter price" name="price" required>
						</div>
						<div class="form-group">
							<label for="quantityRemainProduct">Quantity Remain:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="quantityRemainEditProduct"
								placeholder="Enter quantityRemain" name="quantityRemain" required>
						</div>
						
						<div class="form-group">
							<label for="publisherProduct">Publisher:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="publisherEditProduct"
								placeholder="Enter publisher" name="publisher" required>
						</div>
						
						<div class="form-group">
							<label for="publishYearProduct">Publish Year:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="publishYearEditProduct"
								placeholder="Enter publishYear" name="publishYear" required>
						</div>
						
						<div class="form-group">
							<label for="ImgProduct">Img:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="ImgEditProduct"
								placeholder="Enter Img" name="Img" required>
						</div>
						
						<div class="form-group">
							<label for="creatAtProduct">CreatAt:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="creatAtEditProduct"
								placeholder="Enter creatAt" name="creatAt" required>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success btn-lg">Submit</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form:form>
			</div>

		</div>

	</div>

	<!-- Modal Edit Product -->
	<div id="myModalEditProduct" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form:form id="formEdit" action="product/update" method="post"  modelAttribute="product">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Edit Product</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							 <input type="text" style="height: 2rem" class="form-control hidden" id="idEditProduct" name="id">
						</div>
						<div class="form-group">
							<label for="nameProduct">Name:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="nameEditProduct"
								placeholder="Enter name" name="name" required>
						</div>
						<div class="form-group">
							<label for="descriptionProduct">Description:</label> <input
								type="text" class="form-control" style="height: 2rem"
								id="descriptionEditProduct" placeholder="Enter Description"
								name="description">
						</div>
						<div class="form-group">
							<label for="priceProduct">Price:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="priceEditProduct"
								placeholder="Enter price" name="price" required>
						</div>
						<div class="form-group">
							<label for="quantityRemainProduct">Quantity Remain:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="quantityRemainEditProduct"
								placeholder="Enter quantityRemain" name="quantityRemain" required>
						</div>
						
						<div class="form-group">
							<label for="publisherProduct">Publisher:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="publisherEditProduct"
								placeholder="Enter publisher" name="publisher" required>
						</div>
						
						<div class="form-group">
							<label for="publishYearProduct">Publish Year:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="publishYearEditProduct"
								placeholder="Enter publishYear" name="publishYear" required>
						</div>
						
						<div class="form-group">
							<label for="ImgProduct">Img:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="ImgEditProduct"
								placeholder="Enter Img" name="Img" required>
						</div>
						
						<div class="form-group">
							<label for="UpdateAtProduct">UpdateAt:</label>
							
							<input type="text"
								style="height: 2rem" class="form-control" id="UpdateAtEditProduct"
								placeholder="Enter UpdateAt" name="UpdateAt" required>
						</div>
						
						
						



					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success btn-lg">Submit</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<input type="hidden" id="id" value="">
					</div>
				</form:form>>
			</div>

		</div>
	</div>









	<script>
		$(document)
				.ready(
						function() {

							// Activate tooltip
							$('[data-toggle="tooltip"]').tooltip();

							// Delete Product
							$('table .delete').click(
									function() {
										var id = $(this).parent().find(
												'#idProduct').val();
										$('#formDelete').attr('action',
												'product/delete/' + id);
									});

							//Edit Product
							$('table .edit').click(
									function() {
										var id = $(this).parent().find(
												'#idProduct').val();
										var name = $(this).parent().find(
												'#nameProduct').val();
										var description = $(this).parent().find('#descriptionProduct').val();
										$('#nameEditProduct').val(bookName);
										$('#descriptionEditProduct').val(description);
										$('#idEditProduct').val(bookId);

									});
							
							
			
							
							
						
							// Search
							  $("#myInput").on("keyup", function() {
							    var value = $(this).val().toLowerCase();
							    $("#myTable tr").filter(function() {
							      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
							    });
							  });
						
					
						});
		
		
		//validation
		  
	</script>

</body>
</html>