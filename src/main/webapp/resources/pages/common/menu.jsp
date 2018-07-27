<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 28-Oct-15
Description : This file acts a menu page. -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body bgcolor="#E6B6D2" style=" font-family:verdana">
<h2 align="center">Menu</h2><hr>
<a href="<%=request.getContextPath() %>/listProductFamily.html" target="displayContent" style="font-size:13">Product Family</a><br><br>
<a href="<%=request.getContextPath() %>/listSubstance.html" target="displayContent" style="font-size:13">Substance</a><br><br>
<a href="<%=request.getContextPath() %>/listProduct.html" target="displayContent" style="font-size:13">Product</a>
</body>
</html>