<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 28-Oct-15
Description : This file acts as welcome page for users -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body bgcolor=#EFD8E5 style="font-family: verdana;" topmargin="1px" >
	<form action="<%=request.getContextPath()%>/authenticateUser.html"	target="_top" method="post">
		<table style="width:98%; margin-top:5px" >
			<tr>
				<td align="left" style="font-size:20px; font-weight:bold" >Welcome <%=request.getSession().getAttribute("username")%></td>
				<td align="right"><input type="submit" name="logout" id="logout"	value="Logout">
				<td />
			</tr>
		</table>
	</form>
</body>
</html>