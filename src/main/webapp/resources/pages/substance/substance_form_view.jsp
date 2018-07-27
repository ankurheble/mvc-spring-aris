   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="com.arisglobal.regulatory.team1.entity.Substance"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 29-Oct-2015
Description : This file acts a form view for viewing Substances. -->
<!DOCTYPE html>
<html>
<head>
<title>Substance Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function checkAll(ele) {
		var checkAll = document.getElementById('substanceCategoryAll');
		var subCategory = document.getElementsByName('substanceCategory');
		for (var i = 0; i < subCategory.length; i++) {
			subCategory[i].checked = checkAll.checked;
		}
	}
function checkSome(ele) {
		var checkAll = document.getElementById('substanceCategoryAll');
		var subCategory = document.getElementsByName('substanceCategory');
		if (ele.checked == false) {
			checkAll.checked = false;
		}else if(subCategory[0].checked == true && subCategory[1].checked == true
				&& subCategory[2].checked == true
				&& subCategory[3].checked == true) {
			checkAll.checked = true;
		}
	}
function lookUpOpen() {
	if(window.showModalDialog)
		{
		window.showModalDialog("listSubstanceLookUp.html",'Popup','dialogWidth:1100px; dialogHeight:500px;');
		}
	else{
		var myWindow = window.open("<%=request.getContextPath()%>/listSubstanceLookUp.html","lookUp","width=1100, height=500");
	}
}
function loadCount(){
	document.location.href='<%=request.getContextPath()%>/getCount.html?entityName=Substance';
}
function windowOnLoad(){
	var message = "<%=request.getAttribute("message")%>";
	if(message!=null && message!="" && message!="null"){
		alert(message);	
	}
}
</script>
</head>
<body bgcolor=#EFD8E5 onload="windowOnLoad()" style=" font-family:verdana">
	<form method="POST" name="SubstanceForm">
		<h2 align="center">
			<font color="black">Substance Form</font>
		</h2>
		<input type="button" value="Add" onclick="document.location.href='<%=request.getContextPath()%>/addSubstance.html'"/>
		<input type="submit" value="Save" formaction="<%=request.getContextPath()%>/saveSubstance.html"/>
		<input type="submit" value="Delete" formaction="<%=request.getContextPath()%>/deleteSubstance.html"/>
		<input type="button" value="List View" onclick="document.location.href='<%=request.getContextPath()%>/listSubstance.html'"/><br><br>
		<table id="mainFormBody"  bgcolor='#EEEEEE' style="width: 99%; height: 250px;font-size: 12"  >
			<tr>
				<td align="right">Ingredient ID<span style="color: red;">*</span></td>
				<td colspan="2"><input type="text" name="ingredientId"
					id="ingredientId" maxlength="30" style="width: 75%"
					value="${substance.getIngredientId()}" required readonly="readonly"/></td>
			<% 
				Substance substance=(Substance)request.getAttribute("substance");
				String yesChecked="",noChecked="",activeIngredientChecked="",adjuvantChecked="",materialChecked="",alt_materialChecked="",allChecked="";
				if(substance!=null){
				if("Yes".equals(substance.getActive())){
					yesChecked="checked='checked'";
					noChecked="";
				}else if("No".equals(substance.getActive())){
					yesChecked="";
					noChecked="checked='checked'";
				}else{
					yesChecked="";
					noChecked="";
				}
				}
			%>
				<td colspan="2" align="right">Active<span style="color: red;">*</span>
					<input type="radio" name="active" value="Yes" <%=yesChecked%>/>Yes
					<input type="radio" name="active" value="No" <%=noChecked %>/>No
				</td>
			</tr>

			<tr>
				<td align="right">Ingredient Name<span style="color: red;">*</span></td>
				<td colspan="5"><input type="text" name="ingredientName"
					id="ingredientName" style="width: 99%;"
					value="${substance.getIngredientName()}" /></td>
			</tr>
			<tr>
				<td align="right">Reference Substance</td>
				<td colspan="5"><input type="hidden" name="referenceSubstanceId"
					id="referenceSubstanceId" value="${substance.getReferenceSubstanceId()}"> <input
					type="text" name="referenceSubstanceName" id="referenceSubstanceName"
					style="width: 99%;" value="${substance.getReferenceSubstanceName()}" />
				<td align="left">
					<img src="<%=request.getContextPath()%>/resources/images/magnifier.png" onclick="lookUpOpen()" style="width:20px;height:20px">
				</td>
			</tr>
			<tr>
				<td align="right">Language</td>
				<td align="left" colspan="2"><select style="width: 75%" name="language">
						<option value="English">English</option>
						<option value="French">French</option>
						<option value="Japanese">Japanese</option>
						<option value="Chinese">Chinese</option>
				</select></td>
			</tr>
			<%
				if(substance!=null){
					int set=1;
					if(substance.getActiveIngredient()==set){
						activeIngredientChecked="checked='checked'";
					}
					if(substance.getAdjuvant()==set){
						adjuvantChecked="checked='checked'";
					}
					if(substance.getMaterial()==set){
						materialChecked="checked='checked'";
					}
					if(substance.getAlternateMaterial()==set){
						alt_materialChecked="checked='checked'";
					}
					if(substance.getAllCheck()==set){
						allChecked="checked='checked'";
					}else{
						allChecked="";
					}
				}
			%>
			<tr>
				<td align="right" >Substance Category</td>
				<td><input type="checkbox" id="substanceCategoryAll" onchange="checkAll(this)" <%=allChecked%>/>All</td>
				<td><input type="checkbox" name="substanceCategory" onchange="checkSome(this)" value="activeIngredient" <%=activeIngredientChecked%>/>Active
					Ingredient</td>
				<td><input type="checkbox" name="substanceCategory" onchange="checkSome(this)" value="adjuvant" <%=adjuvantChecked%>/>Adjuvant</td>
				<td><input type="checkbox" name="substanceCategory" onchange="checkSome(this)" value="material" <%=materialChecked%>/>Material</td>
				<td><input type="checkbox" name="substanceCategory" onchange="checkSome(this)" value="alt_material" <%=alt_materialChecked%>/>Alternate
					Material</td>
			</tr>
		</table>
		<input type="hidden" value="${substance.getRecordId()}"
			name="recordId" id="recordId" />
	</form>
</body>
</html>
