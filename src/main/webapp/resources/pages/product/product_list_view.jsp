<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.arisglobal.regulatory.team1.entity.ProductFamily"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 03-Nov-2015
Description : This file acts a list view for viewing Products. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function checkAll() {
   	var selectAll=document.getElementById('selectAll');
   	var subCategory = document.getElementsByName('selectedProduct');
   	if(selectAll.checked==true){
   		for(i=0;i<subCategory.length;i++){
   			subCategory[i].checked=true;
   		}
   	}else if(selectAll.checked==false){
   		for(i=0;i<subCategory.length;i++){
   			subCategory[i].checked=false;
   		}
   	}
}
function checkSome(ele){
   	var selectAll=document.getElementById('selectAll');
   	var subCategory = document.getElementsByName('selectedProduct');
	if(ele.checked==false){
		selectAll.checked=false;
	}
}
function windowOnLoad(){
	var message = "<%=request.getAttribute("message")%>";
	if(message!=null && message!="" && message!="null"){
		alert(message);	
	}
}
</script>
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}

table tr:nth-child(even) {
	background-color: #eee;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table th {
	background-color: black;
	color: white;
}
</style>
</head>
<body bgcolor=#EFD8E5 onload="windowOnLoad()" style=" font-family:verdana">
<h2 align="center">Product List</h2>
	<form method="POST">
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addProduct.html'" />
		<input type="submit" value="Delete" formaction="<%=request.getContextPath()%>/deleteProductList.html"/>
		<input type="text" name="searchKey" id="searchKey"/>
		<input type="submit" name="search" id="search" value="Search" formaction="<%=request.getContextPath()%>/searchProductRecord.html" />
		<input type="button" value="Export" onclick="document.location.href='<%=request.getContextPath()%>/exportProductList.html'" />
		<br/><br/>
		<table border="1" style="font-size:12">
			<tr>
				<th><input type="checkbox" onchange="checkAll()" id="selectAll"/></th>
				<th>Product ID</th>
				<th>Product Family</th>
				<th>Product Name</th>
				<th>Description</th>
				<th>Remarks</th>
				<th>Administrable Dose Form</th>
				<th>Main Ingredient</th>
				<th>Active</th>
			</tr>
			<c:forEach items="${productList}" var="Product">
				<tr>
					<td><input type="checkbox" name="selectedProduct" value="${Product.getRecordId()}" onchange="checkSome(this)"/></td>
					<td><a href="<%=request.getContextPath()%>/editProduct.html?recordId=${Product.getRecordId()}">
					<c:out value="${Product.getProductId()}" /></a></td>
					<td><c:out value="${Product.getReferenceProductFamilyName()}" /></td>
					<td><c:out value="${Product.getProductName()}" /></td>
					<td><c:out value="${Product.getDescription()}" /></td>
					<td><c:out value="${Product.getRemarks()}" /></td>
					<td><c:out value="${Product.getAdministrableDoseForm()}" /></td>
					<td><c:out value="${Product.getReferenceSubstanceName()}" /></td>
					<td><c:out value="${Product.getActive()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>