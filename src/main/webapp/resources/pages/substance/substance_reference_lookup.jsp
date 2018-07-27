<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.arisglobal.regulatory.team1.entity.Substance"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 04-Nov-2015
Description : This file acts a lookup view for viewing Substances. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function lookUp() {
		var selectedId;
		var idsRadioButtons = document.getElementsByName("selectedSubstance");
		for (var i = 0; i < idsRadioButtons.length; i++) {
			if (idsRadioButtons[i].checked == true) {
				selectedId = idsRadioButtons[i].value;
				flag=1;
				break;
			}else{
				flag=0;
			}
		}
		
		if(flag==0){
			alert('please select a substance');
		}

		window.opener.document.getElementById('referenceSubstanceId').value = selectedId;
		window.opener.document.getElementById('referenceSubstanceName').value = document.getElementById('ingredientName'+ selectedId).value;
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

	<h2 align="center">Substance Lookup List</h2>
	<table border="12" style="width: 98%;font-size: 12 ;font-family:verdana">
		<tr>
			<th>Select</th>
			<th>Ingredient ID</th>
			<th>Ingredient name</th>
			<th>Active</th>
			<th>Language</th>
			<th>Reference Substance</th>
			<th>Substance Category</th>
		</tr>
		<c:forEach items="${substanceList}" var="Substance">
			<tr>
				<td><input type="radio" name="selectedSubstance"
					value="${Substance.getRecordId()}" /></td>
				<td><c:out value="${Substance.getIngredientId()}" /></td>
				<td><c:out value="${Substance.getIngredientName()}" /></td>
				<td><c:out value="${Substance.getActive()}" /></td>
				<td><c:out value="${Substance.getLanguage()}" /></td>
				<td><c:out value="${Substance.getReferenceSubstanceName()}" /></td>
				<td><input type="hidden" name="ingredientName${Substance.getRecordId()}" id="ingredientName${Substance.getRecordId()}" value="${Substance.getIngredientName()}"></td>
			</tr>
		</c:forEach>
	</table>
	<div style="position: absolute; top: 400px; left: 800px;">
		<input type="button" name="OK" value="OK" style="height: 20px; width: 100px" onclick="lookUp()" />
		<input type="button" name="Cancel" value="Cancel" style="height: 20px; width: 100px" onclick="window.close()" />
	</div>
</body>
</html>
