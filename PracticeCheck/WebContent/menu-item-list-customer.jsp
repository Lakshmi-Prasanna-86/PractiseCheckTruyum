<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.truyum.model.MenuItem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>MenuItem List for Customers</title>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft">truYum</h1>
		<img src="image/image1.jfif"> <a class="header-itemright"
			href="ShowCartServlet">Cart</a> <a class="header-itemright"
			href="ShowMenuItemListCustomerServlet">Menu</a>
	</header>
	<br>
	<section class="body-main">
		<h2>Menu Items</h2>
		<c:if test="${addCartStatus }">
			<h2 style="color: #00cc88">Item Added To Cart Successfully</h2>
		</c:if>
		<table style="width: 100%;" id="menuitems">
			<tr>
				<th class="th-text-align-left">Name</th>
				<th>Free Delivery</th>
				<th class="th-text-align-right">Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${customerMenuItemList}">
				<tr>
					<td class="td-text-align-left">${item.name}</td>
					<td>${item.freeDelivery? 'Yes' : 'No'}</td>
					<td class="td-text-align-right"><fmt:setLocale value="en_IN" />
						<fmt:formatNumber type="currency" value="${item.price}" /></td>
					<td>${item.category}</td>
					<td><a href="AddToCartServlet?menuItemId=${item.id}">Add
							to cart</a></td>
				</tr>
			</c:forEach>

		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>