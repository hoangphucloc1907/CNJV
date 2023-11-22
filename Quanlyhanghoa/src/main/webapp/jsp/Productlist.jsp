<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
	<h3>Product List</h3>
	<p style="color: red;">${errorString}</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Type</th>
			<th>Price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.type}</td>
				<td>${product.price}</td>
				<td><img src="${product.image}" height="20px" width="20px" /></td>
				<td><a href="editProductServlet?code=${product.id} ">Edit</a></td>
				<td><a href="deleteProductServlet?code=${product.id} ">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="AddProductServlet">Create Product</a>
</body>
</html>