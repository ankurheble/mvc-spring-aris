<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Copyright  1995-2014 PharmApps, LLC.
All Rights Reserved.
This software is the confidential and proprietary information of PharmaSystems, Inc. ("Confidential Information").
Author      : Ankur N Heble, Ashley Rajiv Mathad : Employed By ArisGlobal Software Pvt. Ltd.
Created On  : 28-Oct-15
Description : This file is a frame divided page to hold the other views. -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title >Team1 Application Main Page</title>
</head>
<frameset cols="20%,*" rows="9%,*" bordercolor="white">
<frame src="<%=request.getContextPath()%>/resources/pages/common/image.jsp"/>
<frame src="<%=request.getContextPath()%>/resources/pages/common/welcome.jsp"/>
<frame src="<%=request.getContextPath()%>/resources/pages/common/menu.jsp"/>
<frame src="<%=request.getContextPath()%>/resources/pages/common/home.jsp" name="displayContent"/>
</frameset>
</html>