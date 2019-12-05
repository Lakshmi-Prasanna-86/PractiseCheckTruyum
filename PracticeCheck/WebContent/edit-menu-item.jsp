<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.truyum.model.MenuItem"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>
<head>
<title>Edit Menu Item</title>
<link rel="stylesheet" href="style/style.css">
<script>
	function validateMenuItemForm() {
		var title = document.forms["editMenuForm"]["itemName"].value;
		var price = document.forms["editMenuForm"]["price"].value;
		var launchDate = document.forms["editMenuForm"]["date"].value;
		var category = document.forms["editMenuForm"]["itemType"].value;
		if (title == "") {
			alert("Title is required");
			return false;
		} else if (title.length<2||title.length>65) {
			alert("Title should have 2 to 65 characters");
			return false;
		}
		if (price == "") {
			alert("Price is required");
			return false;
		} else if (isNaN(price)) {
			alert("Price has to be a number");
			return false;
		}
		if (launchDate == "") {
			alert("Date of Launch is required");
			return false;
		}
		if (category == "") {
			alert("Select one category");
			return false;
		}

	}
</script>
<style>
.body-main th {
	text-align: left;
}

.body-main td {
	text-align: left;
}

.button {
	background-color: #004080;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<c:set var="category" value="MainCourse,Starters,Desserts,Drinks"
		scope="application" />
	<c:set var="selected" value="${menuItem.category}" scope="application" />

	<header class="header container-fluid">
		<h1 class="header-itemleft">truYum</h1>
		<img src="image/image1.jfif"> <a class="header-itemright"
			href="ShowMenuItemListAdminServlet">Menu</a>
	</header>
	<section class="body-main">
		<h1 style="padding-top: 20px">Edit Menu Item</h1>


		<form name="editMenuForm" action="EditMenuItemServlet" method="post"
			onsubmit="return validateMenuItemForm()">
			<table style="width: 100%">
				<tr>
					<th colspan="4" style="padding-top: 25px"><label for="mname">Name:</label></th>
				</tr>
				<tr>
					<td colspan="4"><input type="text" id="mname" name="itemName"
						style="width: 75%" value="${fn:trim(menuItem.name)}"></td>
				</tr>

				<tr>
					<th style="padding-top: 25px"><label for="mprice">Price:</label></th>
					<th style="padding-top: 25px"><label for="mactive">Active:</label></th>
					<th style="padding-top: 25px"><label for="mdate">Date
							of Launch:</label></th>
					<th style="padding-top: 25px"><label for="mcategory">Category:</label></th>
				</tr>
				<tr>
					<td><input type="text" name="price" id="mprice"
						value="${menuItem.price}"></td>
					<c:choose>
						<c:when test="${menuItem.active}">
							<td><input type="radio" id="mactive" name="active"
								value="yes" style="font-size: 20px" checked>Yes <input
								type="radio" id="mactive" name="active" value="no"
								style="font-size: 20px">No</td>
						</c:when>
						<c:otherwise>
							<td><input type="radio" id="mactive" name="active"
								value="yes" style="font-size: 20px">Yes <input
								type="radio" id="mactive" name="active" value="no"
								style="font-size: 20px" checked>No</td>
						</c:otherwise>
					</c:choose>
					<td><input type="date" name="date" id="launchDate"
						value=<fmt:formatDate pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}"/>></td>
					<td><select name="itemType">
							<option value="${selected}" selected>${selected}</option>
							<c:forEach items="${category }" var="Categories">
								<c:if test="${Categories!=selected}">
									<option value="${Categories}">${Categories}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td style="padding-top: 25px"><input type="checkbox"
						name="freedelivery" value="${menuItem.freeDelivery}"
						<c:if test="${menuItem.freeDelivery}">checked="checked"</c:if> />
						<label>Free Delivery</label></td>
				</tr>

				<tr>
					<td style="padding-top: 25px"><a
						href="edit-menu-item-status.jsp"><input type="submit"
							class="button" value="Save"></a></td>
				</tr>
			</table>
			<input type="hidden" name="menuId" value="${menuItem.id}">
		</form>
	</section>
	<footer>Copyright©2019</footer>

</body>
</html>