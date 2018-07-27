<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 28-Oct-15
Description : This file acts an icon image of the application. -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>agIDMP image</title>
<%-- <script type="text/javascript">
	function showHomePage() {
		document.forms("imageForm").target = "displayContent";
		document.forms("imageForm").action = '<%=request.getContextPath()%>/resources/pages/common/home.jsp';
		document.forms("imageForm").submit();		
	}
</script> --%>
</head>
<body bgcolor="#E6B6D2" style=" font-family:verdana" topmargin="1px">
<a href="<%=request.getContextPath()%>/resources/pages/common/home.jsp" target="displayContent"><img src="<%=request.getContextPath()%>/resources/images/logo-icon.png" style= "cursor: pointer; cursor: hand; "></a>
</body>
</html>