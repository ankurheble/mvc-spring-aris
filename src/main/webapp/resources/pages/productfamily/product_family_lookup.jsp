<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.arisglobal.regulatory.team1.entity.ProductFamily"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 04-Nov-2015
Description : This file acts a lookup view for viewing Product Family. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function lookUp() {
		var selectedId;
		var idsRadioButtons = document.getElementsByName("selectedProductFamily");
		for (var i = 0; i < idsRadioButtons.length; i++) {
			if (idsRadioButtons[i].checked == true) {
				selectedId = idsRadioButtons[i].value;
				flag=1;break;
			}else{
				flag=0;
			}
		}
		
		if(flag==0){alert('Please select a product family');}

		window.opener.document.getElementById('referenceProductFamilyId').value = selectedId;
		window.opener.document.getElementById('referenceProductFamilyName').value = document.getElementById('productFamilyName'+ selectedId).value;
		window.close();
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

.fixedbutton {
	position: fixed;
	bottom: 560px;
	right: 1000px;
}
</style>
</head>
<body bgcolor=#EFD8E5 style=" font-family:verdana">
	<h2 align="center">Product Family Lookup List</h2>
	<table border="1" style="width: 100%;font-size: 12">
		<tr>
			<th>Select</th>
			<th>Product Family Id</th>
			<th>Product Family Name</th>
			<th>Active</th>
			<th>Remarks</th>
		</tr>
		<c:forEach items="${productFamilyList}" var="ProductFamily">
			<tr>
				<td><input type="radio" name="selectedProductFamily"
					value="${ProductFamily.getRecordId()}" /></td>
				<td><a
					href="<%=request.getContextPath()%>/editProductFamily.html?recordId=${ProductFamily.getRecordId()}">
						<c:out value="${ProductFamily.getProductFamilyId()}" />
				</a></td>
				<td><c:out value="${ProductFamily.getProductFamilyName()}" /></td>
				<td><c:out value="${ProductFamily.getActive()}" /></td>
				<td><c:out value="${ProductFamily.getRemarks()}" /> <input
					type="hidden"
					name="productFamilyName${ProductFamily.getRecordId()}"
					id="productFamilyName${ProductFamily.getRecordId()}"
					value="${ProductFamily.getProductFamilyName()}"></td>
			</tr>
		</c:forEach>
	</table>
	<div style="position: absolute; top: 400px; left: 1000px;">
		<input type="button" name="OK" value="OK" style="height: 20px; width: 100px" onclick="lookUp()" />
		 <input type="button" name="Cancel" value="Cancel" style="height: 20px; width: 100px" onclick="window.close()" />
	</div>
</body>
</html>