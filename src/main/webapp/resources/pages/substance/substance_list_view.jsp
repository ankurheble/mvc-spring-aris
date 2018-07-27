<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.arisglobal.regulatory.team1.entity.Substance"%>
<%@ page
	import="com.arisglobal.regulatory.team1.entity.common.GenericEntity"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 29-Oct-15
Description : This file acts a list view for viewing Substances. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function checkAll() {
		var selectAll = document.getElementById('selectAll');
		var subCategory = document.getElementsByName('selectedSubstance');
		if (selectAll.checked == true) {
			for (i = 0; i < subCategory.length; i++) {
				subCategory[i].checked = true;
			}
		} else if (selectAll.checked == false) {
			for (i = 0; i < subCategory.length; i++) {
				subCategory[i].checked = false;
			}
		}
	}
	function checkSome(ele) {
		var selectAll = document.getElementById('selectAll');
		var subCategory = document.getElementsByName('selectedSubstance');
		if (ele.checked == false) {
			selectAll.checked = false;
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
		<h2 align="center">Substance List</h2>
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addSubstance.html'" />
		<input type="submit" value="Delete" formaction="<%=request.getContextPath()%>/deleteSubstanceList.html"/>
		<input type="text" name="searchKey" id="searchKey" />
		<input type="submit" name="search" id="search" value="Search" formaction="<%=request.getContextPath()%>/searchSubstanceRecord.html" />
		<br><br>
		<table border="1" style="width: 100%;font-size: 12">
			<tr>
				<th><input type="checkbox" onchange="checkAll()" id="selectAll" /></th>
				<th>Ingredient ID</th>
				<th>Ingredient name</th>
				<th>Active</th>
				<th>Language</th>
				<th>Reference Substance</th>
			</tr>
			<c:forEach items="${substanceList}" var="Substance">
				<tr>
					<td><input type="checkbox" name="selectedSubstance"
						value="${Substance.getRecordId()}" onchange="checkSome(this)" /></td>
					<td><a
						href="<%=request.getContextPath()%>/editSubstance.html?recordId=${Substance.getRecordId()}">
							<c:out value="${Substance.getIngredientId()}" />
					</a></td>
					<td><c:out value="${Substance.getIngredientName()}" /></td>
					<td><c:out value="${Substance.getActive()}" /></td>
					<td><c:out value="${Substance.getLanguage()}" /></td>
					<td><c:out value="${Substance.getReferenceSubstanceName()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
