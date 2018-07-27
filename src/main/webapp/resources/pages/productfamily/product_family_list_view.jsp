<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.arisglobal.regulatory.team1.entity.ProductFamily"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 27-Oct-2015
Description : This file acts a list view for viewing Product Families. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function checkAll() {
   	var selectAll=document.getElementById('selectAll');
   	var subCategory = document.getElementsByName('selectedProductFamily');
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
   	var subCategory = document.getElementsByName('selectedProductFamily');
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
	<form method="POST">
		<h2 align="center">Product Family List</h2>
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addProductFamily.html'" />
		<input type="submit" value="Delete" formaction="<%=request.getContextPath()%>/deleteProductFamilyList.html"/>
		<input type="text" name="searchKey" id="searchKey" />
		<input type="submit" name="search" id="search" value="Search" formaction="<%=request.getContextPath()%>/searchProductFamilyRecord.html"/><br/><br/>
		<table border="1" style="font-size:12">	
			<tr>
				<th><input type="checkbox" onchange="checkAll()" id="selectAll"/></th>
				<th>Product Family Id</th>
				<th>Product Family Name</th>
				<th>Active</th>
				<th>Remarks</th>
			</tr>
			<c:forEach items="${productFamilyList}" var="ProductFamily">
				<tr>
					<td><input type="checkbox" name="selectedProductFamily"
						value="${ProductFamily.getRecordId()}" onchange="checkSome(this)"/></td>
					<td><a
						href="<%=request.getContextPath()%>/editProductFamily.html?recordId=${ProductFamily.getRecordId()}"><c:out
								value="${ProductFamily.getProductFamilyId()}" /></a></td>
					<td><c:out value="${ProductFamily.getProductFamilyName()}" /></td>
					<td><c:out value="${ProductFamily.getActive()}" /></td>
					<td><c:out value="${ProductFamily.getRemarks()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>

