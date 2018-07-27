<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 28-Oct-15
Description : This file acts a login page. -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="#E6B6D2" style=" font-family:verdana">
 	<form action="<%=request.getContextPath()%>/authenticateUser.html" method="POST">
		<h2 align="center" style="font-family:verdana">BootCamp Team 1 Application</h2>
		<table align="center" style="font-family:verdana; font-size:12">
			<tr>
				<td align="right" style="font-size:12">Username</td>
				<td><input type="text" name="username" id="username" required></td>
			</tr>
			<tr>
				<td align="right" style="font-size:12">Password</td>
				<td><input type="password" name="password" id="password" required></td>
			</tr>
			<tr>
				<td></td>
				<td colspan="2"><input type="submit" name="login" value="Login" ></td>
			</tr>
		</table>
	</form>
	<h4 align="center" style="color:red; margin-left:5px ; margin-top:30px;font-family:verdana; font-size:12"> ${invalidUser}</h4>
</body>
</html>