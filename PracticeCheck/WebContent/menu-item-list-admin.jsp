<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.truyum.model.MenuItem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="style/style.css">
<title>Menu Item Admin List</title>
</head>
<body>
	<header class="header container-fluid">
		<h1 class="header-itemleft">truYum</h1>
		<img src="image/image1.jfif"> <a class="header-itemright"
			href="ShowMenuItemListAdminServlet">Menu</a>
	</header>
	<br>
	<section class="body-main">
		<h2>Menu Items</h2>
		<table>
			<tr>
				<th class="th-text-align-left">Name</th>
				<th class="th-text-align-right">Price</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Category</th>
				<th>Free Delivery</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${adminMenuItemList}">
				<tr>
					<td class="td-text-align-left">${item.name}</td>
					<td class="td-text-align-right"><fmt:setLocale value="en_IN" />
						<fmt:formatNumber type="currency" value="${item.price}" /></td>
					<td>${item.active?'Yes' : 'No'}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${item.dateOfLaunch}" /></td>
					<td>${item.category}</td>
					<td>${item.freeDelivery?'Yes' : 'No'}</td>
					<td><a href="ShowEditMenuItemServlet?menuItemId=${item.id}">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>