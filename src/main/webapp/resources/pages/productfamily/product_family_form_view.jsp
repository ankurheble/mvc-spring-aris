<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="com.arisglobal.regulatory.team1.entity.ProductFamily"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 27-Oct-2015
Description : This file acts a form view for viewing Product Families. -->
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function windowOnLoad(){
	var message = "<%=request.getAttribute("message")%>";
	if(message!=null && message!="" && message!="null"){
		alert(message);	
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Family Form</title>
</head>
<body bgcolor=#EFD8E5 onload="windowOnLoad()" style=" font-family:verdana">
	<form method="POST" name="productFamilyForm"
		action="<%=request.getContextPath()%>/saveProductFamily.html">
		<h2 align="center">Product Family Form</h2>
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addProductFamily.html'"/>
		<input type="button" value="Delete" onclick="document.location.href='<%=request.getContextPath()%>/deleteProductFamily.html?id=${productFamily.getRecordId()}'"/>
		<input type="submit" value="Save"/>
		<input type="button" value="List View" onclick="document.location.href='<%=request.getContextPath()%>/listProductFamily.html'" /><br><br>
		<table id="mainFormBody" style="width: 90%; height: 300px;font-size:12;background-color:#EEEEEE">
			<tr>
				<td align="right">Product Family ID<span style="color: red;">*</span></td>
				<td><input type="text" name="productFamilyId"
					id="productFamilyId" maxlength="30" style="width: 99%;"
					value="${productFamily.getProductFamilyId()}" required readonly="readonly"/></td>
			<% 
				ProductFamily productFamily=(ProductFamily)request.getAttribute("productFamily");
				String yesChecked="",noChecked="";
				if(productFamily!=null){
				if("Yes".equals(productFamily.getActive())){
					yesChecked="checked='checked'";
					noChecked="";
				}else if("No".equals(productFamily.getActive())){
					yesChecked="";
					noChecked="checked='checked'";
				}else{
					yesChecked="";
					noChecked="";
				}
				}
			%><td align="right">Active<span style="color: red;">*</span></td>
				<td>
					<input type="radio" name="active" value="Yes"  <%=yesChecked%>/>Yes
					<input type="radio" name="active" value="No" <%=noChecked%>/>No
				</td>
			</tr>
			<tr>
				<td align="right">Product Family Name<span style="color: red;">*</span></td>
				<td colspan="2"><input type="text" name="productFamilyName"
					id="productFamilyName" style="width: 98%;"
					value="${productFamily.getProductFamilyName()}" required/></td></tr>
			<tr>
				<td align="right">Remarks</td>
				<td colspan="2"><textarea rows=3 name="remarks" id="remarks" style="width: 98%;height: 60px">
				${productFamily.getRemarks()}</textarea>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${productFamily.getRecordId()}"
			name="recordId" id="recordId" />
	</form>
</body>
</html>