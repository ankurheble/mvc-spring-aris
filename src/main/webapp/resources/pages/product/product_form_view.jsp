<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="com.arisglobal.regulatory.team1.entity.Product"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 03-Nov-2015
Description : This file acts a form view for viewing Products. -->
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function substanceLookUpOpen(){ 
	if(window.showModalDialog)
	{
	window.showModalDialog("listSubstanceLookUp.html",'Popup','dialogWidth:1100px; dialogHeight:500px;');
	}
else{
	var myWindow = window.open("<%=request.getContextPath()%>/listSubstanceLookUp.html","lookUp","width=1100, height=500");
	}
}
function productFamilyLookUpOpen(){
	if(window.showModalDialog)
	{
	window.showModalDialog("listProductFamilyLookUp.html",'Popup','dialogWidth:1250px; dialogHeight:500px;');
	}
else{
	var myWindow = window.open("<%=request.getContextPath()%>/listProductFamilyLookUp.html","lookUp","width=1300, height=500");
	}
}
function windowOnLoad(){
	var message = "<%=request.getAttribute("message")%>";
	if(message!=null && message!="" && message!="null"){
		alert(message);	
	}
}
</script>
</head>
<title>Product Form</title>
<script type="text/javascript">
	
</script>
<body bgcolor=#EFD8E5 onload="windowOnLoad()" style=" font-family:verdana">
	<form method="POST" name="productForm"
		action="<%=request.getContextPath()%>/saveProduct.html">
		<h2 align="center">Product Form </h2>
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addProduct.html'" />
		<input type="Submit" value="Save"/>
		<input type="button" value="Delete" onclick="document.location.href='<%=request.getContextPath()%>/deleteProduct.html?id=${product.getRecordId()}'"/>
		<input type="button" value="List View" onclick="document.location.href='<%=request.getContextPath()%>/listProduct.html'"/>
		<input type="button" value="Export" onclick="document.location.href='<%=request.getContextPath()%>/exportProduct.html?recordId=${product.getRecordId()}'" />
		<br><br>
		<table id="mainFormBody" bgcolor='#EEEEEE' style="width: 99%; height: 325px; font-size:12">
			<tr>
				<td align="right" style="font-size:12" width="15%">Product ID<span style="color: red; align:left;font-size:12">*</span></td>
				<td><input type="hidden" value="${product.getRecordId()}" name="recordId"
			id="recordId" /><input type="text" name="productId" id="productId"
					maxlength="30" value="${product.getProductId()}" required readonly="readonly"/></td>
					
						<% 
				Product product=(Product)request.getAttribute("product");
				String yesChecked="",noChecked="";
				
				if(product!=null){
				if("Yes".equals(product.getActive())){
					yesChecked="checked='checked'";
					noChecked="";
				}else if("No".equals(product.getActive())){
					yesChecked="";
					noChecked="checked='checked'";
				}else{
					yesChecked="";
					noChecked="";
				}
				}
			%>
					
				<td align="right" style="font-size:12">Active<span style="color: red;font-size:12">*</span>
					<input type="radio" name="active" value="Yes" <%=yesChecked%>>Yes
					<input type="radio" name="active" value="No" <%=noChecked%>/>No
				</td>
			</tr>
			
			<tr>
				<td align="right" style="font-size:12">Product Name<span style="color: red;font-size:12">*</span>
				<td><input type="text" name="productName" id="productName" style="width: 99%" maxlength="30" value="${product.getProductName()}" required /></td>
				<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Administrable Dose Form &nbsp;<select name="administrable_dose_form" id="administrable_dose_form" style="width: 30%">
						<option>Oral</option>
						<option>Nasal</option>
						<option>Dermal</option>
						<option>Inhalation</option>
				</select></td>
			</tr>
			<tr>
				<td align="right" style="font-size:12">Product Family <span style="color: red;font-size:12">*</span></td>
				<td colspan="2"><input type="hidden" name="referenceProductFamilyId"
					id="referenceProductFamilyId" value="${product.getReferenceProductFamilyId()}"> <input
					type="text" name="referenceProductFamilyName" id="referenceProductFamilyName" maxlength="30"
					value="${product.getReferenceProductFamilyName()}" style="width:99%" required readonly="readonly"/></td>
					<td align="left"><img src="<%=request.getContextPath()%>/resources/images/magnifier.png" onclick="productFamilyLookUpOpen()" style="width:20px;height:20px">
				</td>
			</tr>
			<tr>
				<td align="right" style="font-size:12">Main Ingredient</td>
				<td colspan="2"><input type="text" name="referenceSubstanceName" id="referenceSubstanceName"
					style="width: 99%;" value="${product.getReferenceSubstanceName()}" style="width:99%" readonly="readonly"/>
					<input type="hidden" name="referenceSubstanceId" id="referenceSubstanceId" value="${product.getReferenceSubstanceId()}"></td><td align="left">
					<img src="<%=request.getContextPath()%>/resources/images/magnifier.png" onclick="substanceLookUpOpen()" style="width:20px;height:20px">
				</td>
			</tr>
			<tr>
				<td align="right" style="font-size:12">Description</td>
				<td colspan="2"><textarea rows=5 cols=100 name="description" id="description" style="width: 99%; height:50px">
				${product.getDescription()}</textarea>
				</td>
			</tr>
			<tr>
				<td align="right" style="font-size:12">Remarks</td>
				<td colspan="2"><textarea rows=5 cols=100 name="remarks" id="remarks" style="width: 99%; height:50px">
				${product.getRemarks()}</textarea>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
